package com.vmanenkov.managers.vk.rest;

public class RelativeRest {
    Long uid; // В документации написано id, но приходит uid :)
    String name;
    String type;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
