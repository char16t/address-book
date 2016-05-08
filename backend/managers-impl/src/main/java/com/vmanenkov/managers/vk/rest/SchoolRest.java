package com.vmanenkov.managers.vk.rest;

import com.google.gson.annotations.SerializedName;
import com.vmanenkov.managers.SocialNetworkInfo;

public class SchoolRest implements SocialNetworkInfo {
    Long id;
    Long country;
    Long city;
    String name;
    Long year_from;
    Long year_to;
    Long year_graduated;

    @SerializedName("class")
    String xclass;

    String speciality;
    Long type;
    String type_str;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYearFrom() {
        return year_from;
    }

    public void setYearFrom(Long year_from) {
        this.year_from = year_from;
    }

    public Long getYearTo() {
        return year_to;
    }

    public void setYearTo(Long year_to) {
        this.year_to = year_to;
    }

    public Long getYearGraduated() {
        return year_graduated;
    }

    public void setYearGraduated(Long year_graduated) {
        this.year_graduated = year_graduated;
    }

    public String getXclass() {
        return xclass;
    }

    public void setXclass(String xclass) {
        this.xclass = xclass;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getTypeStr() {
        return type_str;
    }

    public void setTypeStr(String type_str) {
        this.type_str = type_str;
    }
}
