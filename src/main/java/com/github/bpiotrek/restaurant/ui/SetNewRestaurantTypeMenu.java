package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.model.RestaurantBuilder;
import com.github.bpiotrek.restaurant.model.RestaurantType;

import java.util.Arrays;

public class SetNewRestaurantTypeMenu extends MenuView {

    private final RestaurantBuilder restaurantBuilder;

    public SetNewRestaurantTypeMenu(final RestaurantBuilder builder) {
        this.restaurantBuilder = builder;
    }

    @Override
    public String getMenuText() {
        return "Available types: "
                + Arrays.stream(RestaurantType.values()).map(obj -> obj.toString().toLowerCase()).toList()
                + "\n";
    }

    @Override
    public String getMenuPrompt() {
        return "Restaurant type [turkish]: ";
    }

    @Override
    public void acceptInput(final String input) {
        RestaurantType type;
        if(input.isBlank()) {
            type = RestaurantType.TURKISH;
        } else {
            try {
                type = RestaurantType.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException ignored) {
                ui.invalidResponse();
                return;
            }
        }
        restaurantBuilder.setType(type);
        final var restaurant = restaurantBuilder.build();
        setTransition(new ConfirmationScreen(
                "Are you sure you want to add new restaurnant with following parameters?\n"
                + "Restaurant name: " + restaurant.name() + "\n"
                + "Restaurant address: " + restaurant.address() + "\n"
                + "Restaurant type: " + restaurant.type().toString().toLowerCase() + "\n",
                () -> {}
        ));
    }
}
