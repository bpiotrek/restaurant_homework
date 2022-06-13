package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class MainMenu extends MenuView {

    @Override
    public String getMenuText() {
        return """
                Welcome to the restaurant management app.
                To navigate, please follow instructions below.
                                
                1 - Add new restaurant to Database.
                3 - List available restaurants.
                                
                [opt] - default menu option
                """;
    }

    @Override
    public String getMenuPrompt() {
        return "Option [exit]: ";
    }

    @Override
    public void acceptInput(final String input) {
        switch (input.toLowerCase()) {
            case "", "exit" -> ui.endApp();
            case "1" -> setTransition(new SetNewRestaurantNameMenu(DB.getInstance().getRestaurantBuilder()));
            case "3" -> setTransition(new ListRestaurantsMenu(DB.getInstance()));
            default -> ui.invalidResponse();
        }
    }
}
