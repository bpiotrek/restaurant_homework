package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.model.RestaurantBuilder;

public class MainMenu extends MenuView {

    @Override
    public String getMenuText() {
        return """
                Welcome to the restaurant management app.
                To navigate, please follow instructions below.
                
                1 - Add new restaurant to Database.
                
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
            case "1" -> setTransition(new SetNewRestaurantNameMenu(new RestaurantBuilder()));
            default -> ui.invalidResponse();
        }
    }
}
