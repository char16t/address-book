package com.vmanenkov.managers.vk;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class VK {
    String clientId;
    String redirectUri;
    String scope;
    String response_type;
    String version;
    String clientSecret;
    String authUrl;
    AccessToken accessToken;

    public VK() {
    }

    public VK(String clientId, String redirectUri, String scope, String response_type, String version, String clientSecret) {
        this.clientId = clientId;
        this.redirectUri = redirectUri;
        this.scope = scope;
        this.response_type = response_type;
        this.version = version;
        this.clientSecret = clientSecret;
        this.authUrl = "https://oauth.vk.com/authorize" + "?client_id=" + clientId +
                "&display=page&redirect_uri="+ redirectUri +
                "&scope=" + scope +
                "&response_type=" + response_type +
                "&v=" + version;
    }

    public Object request(Class method, HashMap<String, String> arguments) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        // Create object instance
        Object instance = method.newInstance();

        // Get API method name
        final Field nameField = method.getDeclaredField("name");
        nameField.setAccessible(true);
        Object methodName = nameField.get(instance);

        // Get API vk.rest class for mapping
        final Field restField = method.getDeclaredField("rest");
        restField.setAccessible(true);
        Object methodRest = restField.get(instance);

        // Make request string
        String params = "";
        for (Map.Entry<String, String> entry : arguments.entrySet()) {
            params += entry.getKey() + "=" + entry.getValue() + "&";
        }
        String requestUrl =
                "https://api.vk.com/method/" + methodName + "?" +
                params + "access_token=" + accessToken.getToken();
        System.out.println("DEBUG: " + requestUrl);

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(requestUrl);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));
        String responseString = org.apache.commons.io.IOUtils.toString(rd);

        Gson gson = new Gson();
        Object entity = gson.fromJson(responseString, (Type) methodRest);
        return entity;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
}
