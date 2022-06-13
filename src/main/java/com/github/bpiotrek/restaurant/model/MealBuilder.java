package com.github.bpiotrek.restaurant.model;

public class MealBuilder {

    private String name = "";
    private Double price = 0d;

    public void setName(final String name) {
        this.name = name;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Meal build() {
        return new Meal(name, price);
    }
}
