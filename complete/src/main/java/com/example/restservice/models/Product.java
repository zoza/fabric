package com.example.restservice.models;

public class Product {
    private String name;
    private boolean requireCool;
    private boolean requireHazard;

    public Product(String name) {
        this(name,false,false);
    }
    public Product(String name, boolean requireCool, boolean requireHazard) {
        this.name = name;
        this.requireCool = requireCool;
        this.requireHazard = requireHazard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequireCool() {
        return requireCool;
    }

    public void setRequireCool(boolean requireCool) {
        this.requireCool = requireCool;
    }

    public boolean isRequireHazard() {
        return requireHazard;
    }

    public void setRequireHazard(boolean requireHazard) {
        this.requireHazard = requireHazard;
    }
}
