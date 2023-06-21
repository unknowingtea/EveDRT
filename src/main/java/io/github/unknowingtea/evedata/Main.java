package io.github.unknowingtea.evedata;

import io.github.unknowingtea.evedata.processing.ProcessingUtil;
import io.github.unknowingtea.evedata.reporting.MarketReport;
import io.github.unknowingtea.evedata.reporting.MarketReportType;
import io.swagger.client.ApiException;
import io.swagger.client.model.*;
import io.github.unknowingtea.evedata.sourcing.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        int argIndex = 0;
        if (args.length <= argIndex) {
            printUsage();
            System.exit(1);
        }
        String command = args[argIndex++];
        if (command.equals("auth")) {
            doAuth();
        } else if (command.equals("query")) {
            if (args.length <= argIndex) {
                printUsage();
                System.exit(1);
            }

            String filename = args[argIndex++];

            while(argIndex < args.length) {
                String curArg = args[argIndex++];
                if (curArg.equals("--noApiCache")) {
                    DataSource.useApiCache = false;
                } else {
                    printUsage();
                    System.exit(1);
                }
            }

            doMarketQuery(filename);
        }

        System.exit(0);

    }

    private static void doMarketQuery(String queryFilename) throws Exception {

        MarketQuery query = Util.readJson(queryFilename, MarketQuery.class);
        DataSource data = new DataSource();
        MarketReport.queryAndReport(data, query);
    }

    private static void doAuth() throws Exception {

        DataSource.doAuth();
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("auth");
        System.out.println("query <queryFilename> [--noApiCache]");
    }
}
