package com.github.bpiotrek.restaurant.ui;

import com.github.bpiotrek.restaurant.repository.DB;

public class ListRestaurantsMenu extends MenuView {

    private final DB db;

    public ListRestaurantsMenu(final DB db) {
        this.db = db;
    }

    @Override
    public String getMenuText() {
        final var sb = new StringBuilder();
        sb.append("Available restaurants are:\n");
        db.listRestaurants().forEach(e -> sb
                .append(e.ID())
                .append(" - ")
                .append(e.name())
                .append("; ")
                .append(e.address())
                .append("; ")
                .append(e.type().toString())
                .append("\n")
        );
        return sb.toString();
    }
}
