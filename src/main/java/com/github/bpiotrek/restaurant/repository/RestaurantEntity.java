package com.github.bpiotrek.restaurant.repository;

import com.github.bpiotrek.restaurant.model.Restaurant;
import com.github.bpiotrek.restaurant.model.RestaurantType;

public class RestaurantEntity {

    private final Restaurant restaurant;
    private final Integer id;

    RestaurantEntity(final Integer id, final Restaurant restaurant) {
        this.id = id;
        this.restaurant = restaurant;
    }

    public String name() {
        return restaurant.name();
    }

    public String address() {
        return restaurant.address();
    }

    public RestaurantType type() {
        return restaurant.type();
    }

    public Integer ID() {
        return id;
    }
}
