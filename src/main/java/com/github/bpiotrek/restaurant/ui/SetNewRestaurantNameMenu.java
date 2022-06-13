package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.model.RestaurantBuilder;

public class SetNewRestaurantNameMenu extends MenuView {

    private final RestaurantBuilder restaurantBuilder;

    public SetNewRestaurantNameMenu(final RestaurantBuilder builder) {
        this.restaurantBuilder = builder;
    }

    @Override
    public String getMenuPrompt() {
        return "Restaurant name [unnamed]: ";
    }

    @Override
    public void acceptInput(final String input) {
        restaurantBuilder.setName(input.isBlank() ? "unnamed" : input);
        setTransition(new SetNewRestaurantAddressMenu(restaurantBuilder));
    }
}
