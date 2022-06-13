package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class UpdateRestaurantNameMenu extends MenuView {

    private final DB db;
    private final int restaurantID;

    @Override
    public String getMenuTitle() {
        return "Change Restaurant's name.";
    }

    public UpdateRestaurantNameMenu(final DB db, final int restaurantID) {
        this.db = db;
        this.restaurantID = restaurantID;
    }

    @Override
    public String getMenuPrompt() {
        final var restaurant = db.getRestaurant(restaurantID);
        return "New restaurant name [" + restaurant.name() + "]: ";
    }

    @Override
    public void acceptInput(final String input) {
        if (input.isBlank()) {
            return;
        }

        db.updateRestaurantName(restaurantID, input);
    }
}
