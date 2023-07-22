package io.github.unknowingtea.evedata.sourcing;

import com.squareup.okhttp.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class EveAuth implements HttpHandler {

    private static final String CLIENT_ID = "1fed89fe1599491bb65ed80ae44ca49d";

    private String savedState = null;
    private String savedCodeVerifier = null;

    private String response = null;
    public void authorize() throws Exception {
        StringBuffer buf = new StringBuffer();
        buf.append("https://login.eveonline.com/v2/oauth/authorize/?response_type=code");
        String callbackUri = "http://localhost:8081/callback";
        String encodedCallback = URLEncoder.encode(callbackUri, StandardCharsets.UTF_8.toString());
        buf.append("&redirect_uri=" + encodedCallback);
        buf.append("&client_id=" + CLIENT_ID);
        buf.append("&scope=esi-universe.read_structures.v1%20esi-markets.structure_markets.v1%20esi-assets.read_assets.v1");
        buf.append("&code_challenge_method=S256");

        SecureRandom rnd = new SecureRandom();
        byte[] authRootSecret = new byte[32];
        rnd.nextBytes(authRootSecret);
        SecretKeySpec rootKey = new SecretKeySpec(authRootSecret, "HmacSHA256");

        Mac hmac = Mac.getInstance("HmacSHA256");
        hmac.init(rootKey);

        byte[] CODE_VERIFIER_INFO = {0x00, 0x01};
        byte[] STATE_INFO = {0x00, 0x02};

        byte[] codeVerifierBytes = hmac.doFinal(CODE_VERIFIER_INFO);
        String codeVerifier = Base64.getUrlEncoder().encodeToString(codeVerifierBytes);
        byte[] state = hmac.doFinal(STATE_INFO);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] codeChallenge = digest.digest(codeVerifier.getBytes());
        String encodedCodeChallenge = Base64.getUrlEncoder().encodeToString(codeChallenge).replace("=", "");
        buf.append("&code_challenge=" + encodedCodeChallenge);
        String encodedState = URLEncoder.encode(Base64.getUrlEncoder().encodeToString(state), StandardCharsets.UTF_8.toString());
        buf.append("&state=" + encodedState);
        this.savedState = encodedState;
        this.savedCodeVerifier = codeVerifier;

        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8081), 0);
        server.createContext("/callback", this);
        server.start();
        System.out.println("Started callback server");
        System.out.println();

        System.out.println("Paste this URI into your browser:");
        System.out.println(buf.toString());
        System.out.flush();

        while(true) {
            synchronized(this) {
                if (response != null) {
                    return;
                }
            }

            Thread.sleep(100);
        }
    }

    public String getResponse() {
        return response;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String[] params = exchange.getRequestURI().toString().split("\\?")[1].split("&");
        String codeStr = null;
        String stateStr = null;
        for(String curParam : params) {
            String[] paramPair = curParam.split("=");
            if (paramPair[0].equals("code")) {
                codeStr = paramPair[1];
            } else if (paramPair[0].equals("state")) {
                stateStr = paramPair[1];
            }
        }
        
        if (!stateStr.equals(savedState)) {
            throw new RuntimeException("state doesn't match");
        }

        String responseStr = "success";
        exchange.sendResponseHeaders(200, responseStr.getBytes().length);//response code and length
        OutputStream os = exchange.getResponseBody();
        os.write(responseStr.getBytes());
        os.close();

        OkHttpClient httpClient = new OkHttpClient();

        RequestBody formBody = new FormEncodingBuilder()
                .add("grant_type", "authorization_code")
                .add("code", codeStr)
                .add("client_id", CLIENT_ID)
                .add("code_verifier", savedCodeVerifier)
                .build();

        Request request = new Request.Builder()
                .url("https://login.eveonline.com/v2/oauth/token")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Host", "login.eveonline.com")
                .post(formBody)
                .build();

        Response response = httpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            System.out.println("Unexpected code " + response);
            throw new IOException("Unexpected code " + response);
        }

        synchronized(this) {
            this.response = response.body().string();
        }
    }
}
