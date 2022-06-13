package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class SelectMealsToListMenu extends MenuView {

    private final DB db;

    public SelectMealsToListMenu(final DB db) {
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
            setTransition(new ListMealsMenu(db, restaurantID));
        } catch (NumberFormatException ignored) {
            ui.invalidResponse();
        }
    }
}
