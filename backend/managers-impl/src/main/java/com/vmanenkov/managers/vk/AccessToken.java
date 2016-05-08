package com.vmanenkov.managers.vk;

import com.google.gson.Gson;
import com.vmanenkov.managers.vk.rest.AccessTokenRest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccessToken {
    String token;
    Long expiresIn;
    Long userId;

    public AccessToken() {
    }

    public AccessToken(String token, Long expiresIn, Long userId) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void auth(String code) throws IOException {
        String clientId = "5423946";
        String redirectUri = "http://v.manenkov.com/callback";
        String scope = "friends";
        String response_type = "code";
        String version = "5.50";
        String clientSecret = "ljN7lBf2gQMQqgY8tZvC";

/*
        String AUTH_URL = "https://oauth.vk.com/authorize" +
                "?client_id=" + clientId +
                "&display=page&redirect_uri="+ redirectUri +
                "&scope=" + scope +
                "&response_type=" + response_type +
                "&v=" + version;

        // GET-параметр, пришедший на redirectUri
        //String code = "4ac27206051bde347e";
        System.out.println(AUTH_URL);
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, paste code: ");
        String code = sc.nextLine();
*/

        String ACCESS_TOKEN_URL = "https://oauth.vk.com/access_token" +
                "?client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&redirect_uri=" + redirectUri +
                "&code=" + code;

        // В ответ приходит JSON с данными
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(ACCESS_TOKEN_URL);


        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));
        String authJson = org.apache.commons.io.IOUtils.toString(rd);

        Gson gson = new Gson();
        AccessTokenRest accessTokenRest = gson.fromJson(authJson, AccessTokenRest.class);
        this.token = accessTokenRest.getAccessToken();
        this.expiresIn = Long.parseLong(accessTokenRest.getExpiresIn());
        this.userId = Long.parseLong(accessTokenRest.getUserId());
    }
}
