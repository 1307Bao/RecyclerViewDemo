package com.masterandroid.recyclerviewdemo.model;

import java.io.Serializable;

public class DishModel implements Serializable {
    private String imgSrc;
    private String name;
    private String price;
    private String priceSaled;
    private int rating;

    public DishModel(String imgSrc, String name, String price, String priceSaled, int rating) {
        this.imgSrc = imgSrc;
        this.name = name;
        this.price = price;
        this.priceSaled = priceSaled;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceSaled() {
        return priceSaled;
    }

    public void setPriceSaled(String priceSaled) {
        this.priceSaled = priceSaled;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
