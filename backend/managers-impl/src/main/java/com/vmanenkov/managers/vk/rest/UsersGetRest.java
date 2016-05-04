package com.vmanenkov.managers.vk.rest;

import java.util.List;

public class UsersGetRest {
    List<UserRest> response;

    public List<UserRest> getResponse() {
        return response;
    }

    public void setResponse(List<UserRest> response) {
        this.response = response;
    }
}
