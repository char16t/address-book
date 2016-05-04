package com.vmanenkov.managers.vk.rest;

public class UniversityRest {
    Long id;
    Long country;
    Long city;
    String name;
    Long faculty;
    String faculty_name;
    Long chair;
    String chair_name;
    Long graduation;

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

    public Long getFaculty() {
        return faculty;
    }

    public void setFaculty(Long faculty) {
        this.faculty = faculty;
    }

    public String getFacultyName() {
        return faculty_name;
    }

    public void setFacultyName(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public Long getChair() {
        return chair;
    }

    public void setChair(Long chair) {
        this.chair = chair;
    }

    public String getChairName() {
        return chair_name;
    }

    public void setChairName(String chair_name) {
        this.chair_name = chair_name;
    }

    public Long getGraduation() {
        return graduation;
    }

    public void setGraduation(Long graduation) {
        this.graduation = graduation;
    }
}
