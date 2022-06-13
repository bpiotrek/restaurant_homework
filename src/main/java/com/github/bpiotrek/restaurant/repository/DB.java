package com.github.bpiotrek.restaurant.repository;

import com.github.bpiotrek.restaurant.model.Meal;
import com.github.bpiotrek.restaurant.model.Restaurant;
import com.github.bpiotrek.restaurant.model.RestaurantType;

import java.util.HashMap;
import java.util.Map;

public class DB {
    private static final DB INSTANCE = new DB();

    public static DB getInstance() {
        return INSTANCE;
    }

    private final Map<Integer, Restaurant> restaurants = new HashMap<>();
    private final Map<Integer, Meal> meals = new HashMap<>();
//    private final Map<Integer, Set<Integer>> mealAssoc = new HashMap<>();

    private DB() {
        insertRestaurant(new Restaurant("Kebab u grubego", "Warszawska 11, Kraków 31-222", RestaurantType.TURKISH));
        insertRestaurant(new Restaurant("Milano Pizza", "Sobczyka 12/3, Warszawa 33-312", RestaurantType.ITALIAN));
        insertRestaurant(new Restaurant("Meat Burger", "Lipowa 31b/1, Gdańsk 18-111", RestaurantType.AMERICAN));
    }

    public void insertRestaurant(Restaurant restaurant) {
        restaurants.put(restaurants.size(), restaurant);
    }

    public void insertMeal(Meal meal) {
        meals.put(meals.size(), meal);
    }
}
