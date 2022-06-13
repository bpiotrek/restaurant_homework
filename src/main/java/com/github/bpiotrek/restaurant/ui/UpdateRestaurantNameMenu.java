package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class UpdateRestaurantNameMenu extends MenuView {

    private final DB db;
    private final int restaurantID;

    public UpdateRestaurantNameMenu(final DB db, final int restaurantID) {
        this.db = db;
        this.restaurantID = restaurantID;
    }

    @Override
    public String getMenuPrompt() {
        return "New restaurant name [current]: ";
    }

    @Override
    public void acceptInput(final String input) {
        if(input.isBlank()) {
            return;
        }

        db.updateRestaurantName(restaurantID, input);
    }
}
