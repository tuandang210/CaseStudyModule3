package com.codegym.model;

public class RentalPerson {
    public static int MIN_AGE = 19, MAX_AGE = 30;

    private int id;
    private String name;
    private int age;
    private String gender;
    private boolean status;
    private String phone, urlImage;

    public RentalPerson() {
    }

    public RentalPerson(int id, String name, int age, String gender, boolean status, String phone, String urlImage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.phone = phone;
        this.urlImage = urlImage;
    }

    public RentalPerson(String name, int age, String gender, boolean status, String phone, String urlImage) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.phone = phone;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
