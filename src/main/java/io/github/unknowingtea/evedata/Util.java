package io.github.unknowingtea.evedata;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    private static ObjectMapper mapper = null;
    public static ObjectMapper objectMapperInstance() {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }

        return mapper;
    }

    public static <T> T readJson(String filename, Class<T> cls) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filename));
        String queryJson = new String(encoded, Charset.defaultCharset());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(queryJson, cls);
        } catch (Exception ex) {
            throw new IOException("Error while parsing file: " + filename, ex);
        }
    }

    public static void writeJson(String filename, Object obj) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filename), obj);
        } catch (Exception ex) {
            throw new IOException("Error while writing file: " + filename, ex);
        }
    }
}
