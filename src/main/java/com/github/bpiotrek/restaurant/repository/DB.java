package com.github.bpiotrek.restaurant.repository;

import com.github.bpiotrek.restaurant.model.Meal;
import com.github.bpiotrek.restaurant.model.Restaurant;
import com.github.bpiotrek.restaurant.model.RestaurantType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DB {

    private static final DB INSTANCE = new DB();
    private final Map<Integer, RestaurantEntity> restaurants = new HashMap<>();
    private final Map<Integer, Meal> meals = new HashMap<>();
    private Integer restaurantCounter = 0;
    private DB() {
        insertRestaurant(new Restaurant("Kebab u grubego", "Warszawska 11, Kraków 31-222", RestaurantType.TURKISH));
        insertRestaurant(new Restaurant("Milano Pizza", "Sobczyka 12/3, Warszawa 33-312", RestaurantType.ITALIAN));
        insertRestaurant(new Restaurant("Meat Burger", "Lipowa 31b/1, Gdańsk 18-111", RestaurantType.AMERICAN));
    }
//    private final Map<Integer, Set<Integer>> mealAssoc = new HashMap<>();

    public void insertRestaurant(Restaurant restaurant) {
        final var id = fetchNewRestaurantID();
        restaurants.put(id, new RestaurantEntity(id, restaurant));
    }

    public Integer fetchNewRestaurantID() {
        return restaurantCounter++;
    }

    public static DB getInstance() {
        return INSTANCE;
    }

    public RestaurantEntityBuilder getRestaurantBuilder() {
        return new RestaurantEntityBuilder(this);
    }

    public Collection<RestaurantEntity> listRestaurants() {
        return restaurants.values();
    }

    public void insertMeal(Meal meal) {
        meals.put(meals.size(), meal);
    }
}
