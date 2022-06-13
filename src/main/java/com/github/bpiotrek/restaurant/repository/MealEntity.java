package com.github.bpiotrek.restaurant.repository;

import com.github.bpiotrek.restaurant.model.Meal;

public class MealEntity {

    private final Meal meal;
    private final int id;

    MealEntity(final int id, final Meal meal) {
        this.id = id;
        this.meal = meal;
    }

    public String name() {
        return meal.name();
    }

    public double price() {
        return meal.price();
    }

    public int restaurantID() {
        return meal.restaurantID();
    }

    public int ID() {
        return id;
    }
}
