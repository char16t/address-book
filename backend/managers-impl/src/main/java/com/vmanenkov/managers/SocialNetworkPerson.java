package com.vmanenkov.managers;

import com.vmanenkov.managers.vk.rest.UserRest;

public class SocialNetworkPerson {
    SocialNetworkInfo person;

    public SocialNetworkPerson(SocialNetworkInfo person) {
        this.person = person;
    }
    
    public void write() {
        if (person instanceof UserRest) {
            // ...
        }
    }
}
