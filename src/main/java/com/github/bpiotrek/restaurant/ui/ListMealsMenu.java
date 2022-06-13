package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class ListMealsMenu extends MenuView {

    private final DB db;
    private final int restaurantID;

    public ListMealsMenu(final DB db, final int restaurantID) {
        this.db = db;
        this.restaurantID = restaurantID;
    }

    @Override
    public String getMenuText() {
        final var sb = new StringBuilder();
        sb.append("Available meals for restaurant: ").append(restaurantID).append("\n");
        db.listMeals(restaurantID).forEach(e -> sb
                .append(e.ID())
                .append(" - ")
                .append(e.name())
                .append("; ")
                .append(e.price())
                .append("\n")
        );
        return sb.toString();
    }
}
