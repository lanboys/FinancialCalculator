package com.bing.lan.fc.domian;

public class Platform {

    private String id;
    private String platformName;

    @Override
    public String toString() {
        return "Platform{" +
                "id='" + id + '\'' +
                ", platformName='" + platformName + '\'' +
                '}';
    }

    public Platform() {
    }

    public Platform(String id, String platformName) {
        this.id = id;
        this.platformName = platformName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
}
