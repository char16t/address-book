package com.vmanenkov.managers.vk.rest;

import com.vmanenkov.managers.SocialNetworkInfo;

import java.util.List;

public class UsersGetRest implements SocialNetworkInfo {
    List<UserRest> response;

    public List<UserRest> getResponse() {
        return response;
    }

    public void setResponse(List<UserRest> response) {
        this.response = response;
    }
}
