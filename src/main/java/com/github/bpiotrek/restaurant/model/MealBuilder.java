package com.github.bpiotrek.restaurant.model;

public class MealBuilder {

    private String name = "";
    private double price = 0d;
    private Integer restaurantID = null;

    public void setName(final String name) {
        this.name = name;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public void setRestaurantID(final int id) {
        restaurantID = id;
    }

    public Meal build() {
        return new Meal(name, price, restaurantID);
    }
}
