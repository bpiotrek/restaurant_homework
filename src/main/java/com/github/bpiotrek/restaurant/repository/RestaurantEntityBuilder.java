package com.github.bpiotrek.restaurant.repository;

import com.github.bpiotrek.restaurant.model.RestaurantBuilder;

public class RestaurantEntityBuilder extends RestaurantBuilder {

    private final DB db;

    RestaurantEntityBuilder(final DB db) {
        this.db = db;
    }

    public void insert() {
        db.insertRestaurant(this.build());
    }
}
