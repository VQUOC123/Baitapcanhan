package com.example.recyclerview; // Kiểm tra tên gói của bạn

public class MyModel {

    // 1. Khai báo 7 trường
    private int image;
    private String title;
    private String description; // <-- Trường này bị thiếu
    private String location;
    private double rating;
    private String days;        // <-- Phải là String
    private String activities;

    // 2. Constructor CHUẨN (7 tham số)
    public MyModel(int image, String title, String description, String location, double rating, String days, String activities) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.location = location;
        this.rating = rating;
        this.days = days;
        this.activities = activities;
    }

    // 3. Các hàm Getters
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getRating() {
        return rating;
    }

    public String getDays() { // <-- Phải là String
        return days;
    }

    public String getActivities() {
        return activities;
    }

    // (Không có 'price' ở đây)
}