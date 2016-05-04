package com.vmanenkov.managers.vk.rest;

import com.vmanenkov.managers.SocialNetworkInfo;

import java.util.List;

// TODO: не полная поддержка. Нужно добавить поля
// TODO: https://vk.com/dev/friends.get
public class FriendsGetRest implements SocialNetworkInfo {
    List<Long> response;

    public List<Long> getResponse() {
        return response;
    }

    public void setResponse(List<Long> response) {
        this.response = response;
    }
}
