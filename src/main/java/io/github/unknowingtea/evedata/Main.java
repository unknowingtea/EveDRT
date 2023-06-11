package io.github.unknowingtea.evedata;

import io.github.unknowingtea.evedata.processing.ProcessingUtil;
import io.github.unknowingtea.evedata.reporting.MarketReportType;
import io.swagger.client.ApiException;
import io.swagger.client.model.*;
import io.github.unknowingtea.evedata.sourcing.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length <= 0) {
            printUsage();
            System.exit(1);
        }

        String filename = args[0];
        MarketQuery query = Util.readJson(filename, MarketQuery.class);
    }

    private static void printUsage() {
        System.out.println("Usage: evedrt <queryFilename>");
    }

}
