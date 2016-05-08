package com.vmanenkov.managers.vk.rest;

import com.vmanenkov.managers.SocialNetworkInfo;

public class AccessTokenRest implements SocialNetworkInfo {
    String access_token;
    String expires_in;
    String user_id;

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String access_token) {
        this.access_token = access_token;
    }

    public String getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }
}
