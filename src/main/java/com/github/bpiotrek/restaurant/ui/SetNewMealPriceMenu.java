package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.MealEntityBuilder;

public class SetNewMealPriceMenu extends MenuView {

    private final MealEntityBuilder mealBuilder;

    public SetNewMealPriceMenu(final MealEntityBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    @Override
    public String getMenuTitle() {
        return "Add New Meal (set price)";
    }

    @Override
    public String getMenuText() {
        return "Provide price for the new meal you would like to create.\n";
    }

    public String getMenuPrompt() {
        return "Meal price [0.00]: ";
    }

    @Override
    public void acceptInput(final String input) {
        var price = 0d;
        if (!input.isBlank()) {
            try {
                price = Double.parseDouble(input);
            } catch (NumberFormatException ignored) {
                ui.invalidResponse("wrong value format: ");
                return;
            }
        }
        mealBuilder.setPrice(price);
        setTransition(new SetNewMealAssignRestaurantMenu(mealBuilder));
    }
}
