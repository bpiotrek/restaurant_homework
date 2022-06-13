package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.MealEntityBuilder;

public class SetNewMealNameMenu extends MenuView {

    private final MealEntityBuilder mealBuilder;

    public SetNewMealNameMenu(final MealEntityBuilder builder) {
        this.mealBuilder = builder;
    }

    @Override
    public String getMenuTitle() {
        return "Add New Meal (set name)";
    }

    @Override
    public String getMenuText() {
        return "Provide name for the meal you would like to create.\n";
    }

    @Override
    public String getMenuPrompt() {
        return "Meal name [unknown]: ";
    }

    @Override
    public void acceptInput(final String input) {
        mealBuilder.setName(input.isBlank() ? "unknown" : input);
        setTransition(new SetNewMealPriceMenu(mealBuilder));
    }
}
