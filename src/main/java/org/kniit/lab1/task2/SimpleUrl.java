package org.kniit.lab1.task2;

public class SimpleUrl {
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webPageExtention;

    public String getProtocol() {
        return protocol;
    }

    public String getAddress() {
        return address;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public String getWebPageExtention() {
        return webPageExtention;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public void setWebPageExtention(String webPageExtention) {
        this.webPageExtention = webPageExtention;
    }

    @Override
    public String toString() {
        return "protocol = " + protocol + "\n" +
                "address = " + address + "\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" +
                "webpageName = " + webpageName + "\n" +
                "webPageExtention = " + webPageExtention;
    }
}