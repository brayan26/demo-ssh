package com.example.demo.domain.helm;

public class HelmResponse {
    private String name;
    private String version;
    private String path;

    public HelmResponse() {
    }

    public HelmResponse(String name, String version, String path) {
        this.name = name;
        this.version = version;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
