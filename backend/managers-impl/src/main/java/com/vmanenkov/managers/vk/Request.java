package com.vmanenkov.managers.vk;

import java.util.HashMap;

public class Request {
    String method;
    HashMap<String, String> arguments;
    AccessToken accessToken;

    public Request() {
    }

    public Request(String method, HashMap<String, String> arguments, AccessToken accessToken) {
        this.method = method;
        this.arguments = arguments;
        this.accessToken = accessToken;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public HashMap<String, String> getArguments() {
        return arguments;
    }

    public void setArguments(HashMap<String, String> arguments) {
        this.arguments = arguments;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public String execute() {
        return null;
    }
}
