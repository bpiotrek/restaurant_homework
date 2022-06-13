package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.model.RestaurantType;
import com.github.bpiotrek.restaurant.repository.RestaurantEntityBuilder;

import java.util.Arrays;

public class SetNewRestaurantTypeMenu extends MenuView {

    private final RestaurantEntityBuilder restaurantBuilder;

    public SetNewRestaurantTypeMenu(final RestaurantEntityBuilder builder) {
        this.restaurantBuilder = builder;
    }

    @Override
    public String getMenuTitle() {
        return "Add New Restaurant (set type)";
    }

    @Override
    public String getMenuText() {
        return "Provide restaurant type for the new restaurant you would like to create.\nAvailable types: "
                + Arrays.stream(RestaurantType.values()).map(RestaurantType::toString).toList()
                + "\n";
    }

    @Override
    public String getMenuPrompt() {
        return "Restaurant type [turkish]: ";
    }

    @Override
    public void acceptInput(final String input) {
        RestaurantType type = RestaurantType.TURKISH;
        if (!input.isBlank()) {
            try {
                type = RestaurantType.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException ignored) {
                ui.invalidResponse("incorrect type: ");
                return;
            }
        }
        restaurantBuilder.setType(type);
        final var restaurant = restaurantBuilder.build();
        setTransition(new ConfirmationScreen(
                "Are you sure you want to add new restaurnant with following parameters?\n"
                        + "Restaurant name: " + restaurant.name() + "\n"
                        + "Restaurant address: " + restaurant.address() + "\n"
                        + "Restaurant type: " + restaurant.type().toString() + "\n",
                restaurantBuilder::insert
        ));
    }
}
