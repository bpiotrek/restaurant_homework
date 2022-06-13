package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class SelectRestaurantToBeUpdatedMenu extends MenuView {
    private final DB db;

    @Override
    public String getMenuTitle() {
        return "Update Restaurant Name (select restaurant)";
    }

    @Override
    public String getMenuText() {
        return "Select restaurant you would like to change name for.\n";
    }

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
                ui.invalidResponse("restaurant ID doesn't exist: ");
                return;
            }
            setTransition(new UpdateRestaurantNameMenu(db, restaurantID));
        } catch (NumberFormatException ignored) {
            ui.invalidResponse("invalid restaurant ID: ");
        }
    }
}
