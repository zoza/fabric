package com.example.restservice.models;

import java.util.ArrayList;

public class Cell {
    private int capacity;
    private boolean cool;
    private boolean hazard;
    private String product = null;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }



    public Cell(int capacity, boolean cool, boolean hazard) {
        this.capacity = capacity;
        this.cool = cool;
        this.hazard = hazard;

    }



    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isCool() {
        return cool;
    }

    public void setCool(boolean cool) {
        this.cool = cool;
    }

    public boolean isHazard() {
        return hazard;
    }

    public void setHazard(boolean hazard) {
        this.hazard = hazard;
    }


}
