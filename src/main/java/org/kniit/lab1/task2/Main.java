package org.kniit.lab1.task2;

public class Main {
    public static void main(String[] args) {
        SimpleUrl url = new SimpleUrl();

        url.setProtocol("https");
        url.setAddress("test.ru");
        url.setDomainZone("ru");
        url.setSiteName("test");
        url.setWebpageName("page.jsp");
        url.setWebPageExtention("jsp");

        System.out.println(url.toString());
    }
}