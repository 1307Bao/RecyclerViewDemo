package com.masterandroid.recyclerviewdemo.model;

import java.util.ArrayList;

public class FoodModel {

    private String imgSrc;
    private String name;
    private int quantity, quantitySaled;
    private ArrayList<DishModel> dishModels;

    public FoodModel(String imgSrc, String name, ArrayList<DishModel> dishModels) {
        this.imgSrc = imgSrc;
        this.name = name;
        this.dishModels = dishModels;
        quantity = dishModels.size();
        quantitySaled = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<DishModel> getDishModels() {
        return dishModels;
    }

    public void setDishModels(ArrayList<DishModel> dishModels) {
        this.dishModels = dishModels;
        quantity = dishModels.size();
        quantitySaled = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getQuantitySaled() {
        return quantitySaled;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
