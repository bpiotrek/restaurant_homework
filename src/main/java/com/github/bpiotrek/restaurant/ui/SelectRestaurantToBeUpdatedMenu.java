package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class SelectRestaurantToBeUpdatedMenu extends MenuView {
    private final DB db;

    public SelectRestaurantToBeUpdatedMenu(final DB db) {
        this.db = db;
    }

    @Override
    public String getMenuPrompt() {
        return "Restaurant ID: ";
    }

    @Override
    public void acceptInput(final String input) {
        try {
            int restaurantID = Integer.parseInt(input);
            if(!db.hasRestaurant(restaurantID)) {
                ui.invalidResponse();
                return;
            }
            setTransition(new UpdateRestaurantNameMenu(db, restaurantID));
        } catch (NumberFormatException ignored) {
            ui.invalidResponse();
        }
    }
}
