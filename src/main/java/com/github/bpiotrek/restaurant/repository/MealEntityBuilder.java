package com.github.bpiotrek.restaurant.repository;

import com.github.bpiotrek.restaurant.model.MealBuilder;

public class MealEntityBuilder extends MealBuilder {

    private final DB db;

    MealEntityBuilder(final DB db) {
        this.db = db;
    }

    public void insert() {
        db.insertMeal(this.build());
    }
}
