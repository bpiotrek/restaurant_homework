package com.github.bpiotrek.restaurant.model;

public enum RestaurantType {
    ASIAN, ITALIAN, FRENCH, AMERICAN, TURKISH;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
