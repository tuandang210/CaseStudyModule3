package com.codegym.model;

public class User {
    private int userId;
    private String userName;
    private String passWord;
    private String gender;
    private String phone;
    private int level;

    public User() {
    }

    public User(int userId, String userName, String passWord, String gender, String phone, int level) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        this.phone = phone;
        this.level = level;
    }

    public User(String userName, String passWord, String gender, String phone, int level) {
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        this.phone = phone;
        this.level = level;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
