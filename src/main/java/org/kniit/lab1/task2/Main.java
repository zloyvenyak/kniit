package org.kniit.lab1.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String urlString = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";

        SimpleUrl simpleUrl = new SimpleUrl();

        String[] protocolSplit = urlString.split("://");
        simpleUrl.setProtocol(protocolSplit[0]);
        String rest = protocolSplit[1];

        String[] addressAndQuery = rest.split("\\?");
        System.out.println(Arrays.toString(addressAndQuery));
        String addressAndPath = addressAndQuery[0];
        String query;
        if (addressAndQuery.length > 1) {
            query = addressAndQuery[1];
        } else {
            query = "";
        }

        String[] hostAndPathSplit = addressAndPath.split("/", 2);
        System.out.println(Arrays.toString(hostAndPathSplit));
        String host = hostAndPathSplit[0];
        String path;
        if (hostAndPathSplit.length > 1) {
            path = hostAndPathSplit[1];
        } else {
            path = "";
        }

        simpleUrl.setAddress(host);

        String[] hostParts = host.split("\\.");
        if (hostParts.length >= 2) {
            simpleUrl.setSiteName(hostParts[0]);
            simpleUrl.setDomainZone(hostParts[1]);
        }

        String[] pathParts = path.split("/");
        String lastPart = pathParts[pathParts.length - 1];

        simpleUrl.setWebpageName(lastPart);

        if (lastPart.contains(".")) {
            String[] nameParts = lastPart.split("\\.");
            if (nameParts.length == 2) {
                simpleUrl.setWebPageExtention(nameParts[1]);
            }
        }

        System.out.println(simpleUrl);
    }
}