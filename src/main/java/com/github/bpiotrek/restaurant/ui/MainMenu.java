package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class MainMenu extends MenuView {

    @Override
    public String getMenuText() {
        return """
                Welcome to the restaurant management app.
                To navigate, please follow instructions below.
                                
                1 - Add new restaurant to Database.
                2 - Add new meal to Database.
                3 - List available restaurants.
                4 - List available meals per restaurant.
                5 - Change restaurant's name.
                                
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
            case "2" -> setTransition(new SetNewMealNameMenu(DB.getInstance().getMealBuilder()));
            case "3" -> setTransition(new ListRestaurantsMenu(DB.getInstance()));
            case "4" -> setTransition(new SelectMealsToListMenu(DB.getInstance()));
            case "5" -> setTransition(new SelectRestaurantToBeUpdatedMenu(DB.getInstance()));
            default -> ui.invalidResponse();
        }
    }
}
