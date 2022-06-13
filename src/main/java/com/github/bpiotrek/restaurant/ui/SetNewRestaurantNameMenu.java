package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.RestaurantEntityBuilder;

public class SetNewRestaurantNameMenu extends MenuView {

    private final RestaurantEntityBuilder restaurantBuilder;

    public SetNewRestaurantNameMenu(final RestaurantEntityBuilder builder) {
        this.restaurantBuilder = builder;
    }

    @Override
    public String getMenuPrompt() {
        return "Restaurant name [unnamed]: ";
    }

    @Override
    public String getMenuTitle() {
        return "Add New Restaurant (set name)";
    }

    @Override
    public String getMenuText() {
        return "Provide name for the restaurant you would like to add.\n";
    }

    @Override
    public void acceptInput(final String input) {
        restaurantBuilder.setName(input.isBlank() ? "unnamed" : input);
        setTransition(new SetNewRestaurantAddressMenu(restaurantBuilder));
    }
}
