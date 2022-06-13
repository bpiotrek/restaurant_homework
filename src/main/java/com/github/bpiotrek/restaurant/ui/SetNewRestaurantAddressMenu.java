package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.RestaurantEntityBuilder;

public class SetNewRestaurantAddressMenu extends MenuView {

    private final RestaurantEntityBuilder restaurantBuilder;

    public SetNewRestaurantAddressMenu(final RestaurantEntityBuilder builder) {
        this.restaurantBuilder = builder;
    }

    @Override
    public String getMenuPrompt() {
        return "Restaurant address [unknown]: ";
    }

    @Override
    public void acceptInput(final String input) {
        restaurantBuilder.setAddress(input.isBlank() ? "unknown" : input);
        setTransition(new SetNewRestaurantTypeMenu(restaurantBuilder));
    }
}
