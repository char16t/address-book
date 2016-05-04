package com.vmanenkov.managers.vk.rest;

import com.vmanenkov.managers.SocialNetworkInfo;

public class PersonalRest implements SocialNetworkInfo {
    Long political;
    String langs;
    String religion;
    String inspired_by;
    String people_main;
    String life_main;
    String smoking;
    String alcohol;

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public Long getPolitical() {
        return political;
    }

    public void setPolitical(Long political) {
        this.political = political;
    }

    public String getLangs() {
        return langs;
    }

    public void setLangs(String langs) {
        this.langs = langs;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getInspiredBy() {
        return inspired_by;
    }

    public void setInspiredBy(String inspired_by) {
        this.inspired_by = inspired_by;
    }

    public String getPeopleMain() {
        return people_main;
    }

    public void setPeopleMain(String people_main) {
        this.people_main = people_main;
    }

    public String getLifeMain() {
        return life_main;
    }

    public void setLifeMain(String life_main) {
        this.life_main = life_main;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }
}
