package com.codegym.model;

public class OrderDetail {
    private int orderId;
    private int userId;
    private int personId;
    private double price;
    private float hours;
    private String startHour;

    public OrderDetail() {
    }

    public OrderDetail(int userId, int personId, double price, float hours, String startHour) {
        this.userId = userId;
        this.personId = personId;
        this.price = price;
        this.hours = hours;
        this.startHour = startHour;
    }

    public OrderDetail(int orderId, int userId, int personId, double price, float hours, String startHour) {
        this.orderId = orderId;
        this.userId = userId;
        this.personId = personId;
        this.price = price;
        this.hours = hours;
        this.startHour = startHour;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }
}