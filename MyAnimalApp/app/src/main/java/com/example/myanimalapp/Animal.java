package com.example.myanimalapp;

public class Animal {
    String name;
    int imageResId;

    // Bỏ viewType ra khỏi constructor
    public Animal(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}