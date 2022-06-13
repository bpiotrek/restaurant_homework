package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.MealEntityBuilder;

public class SetNewMealAssignRestaurantMenu extends MenuView {

    private final MealEntityBuilder mealBuilder;

    public SetNewMealAssignRestaurantMenu(final MealEntityBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    @Override
    public String getMenuText() {
        return "Select restaurant you would like assign this meal to.\n";
    }

    @Override
    public String getMenuTitle() {
        return "Add New Meal (select restaurant)";
    }

    public String getMenuPrompt() {
        return "Restaurant ID: ";
    }

    @Override
    public void acceptInput(final String input) {
        try {
            final var id = Integer.parseInt(input);
            mealBuilder.setRestaurantID(id);
        } catch (NumberFormatException ignored) {
            ui.invalidResponse("invalid restaurant ID: ");
            return;
        }

        final var meal = mealBuilder.build();
        setTransition(new ConfirmationScreen(
                "Are you sure you want to add new meal with following parameters?\n"
                        + "Meal name: " + meal.name() + "\n"
                        + "Meal price: " + meal.price() + "\n"
                        + "Restaurant ID meals belongs to: " + meal.restaurantID() + "\n",
                mealBuilder::insert
        ));
    }
}
