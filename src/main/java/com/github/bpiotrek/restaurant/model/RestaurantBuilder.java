package com.github.bpiotrek.restaurant.model;

public class RestaurantBuilder {

    private String name = "";
    private String address = "";
    private RestaurantType type = RestaurantType.AMERICAN;

    public void setName(final String name) {
        this.name = name;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setType(final RestaurantType type) {
        this.type = type;
    }

    public Restaurant build() {
        return new Restaurant(name, address, type);
    }
}
