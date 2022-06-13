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
    private final Map<Integer, MealEntity> meals = new HashMap<>();
    private int restaurantCounter = 0;
    private int mealCounter = 0;

    private DB() {
        insertRestaurant(new Restaurant("Kebab u grubego", "Warszawska 11, Kraków 31-222", RestaurantType.TURKISH));
        insertRestaurant(new Restaurant("Milano Pizza", "Sobczyka 12/3, Warszawa 33-312", RestaurantType.ITALIAN));
        insertRestaurant(new Restaurant("Meat Burger", "Lipowa 31b/1, Gdańsk 18-111", RestaurantType.AMERICAN));
    }

    public void insertRestaurant(Restaurant restaurant) {
        final var id = fetchNewRestaurantID();
        restaurants.put(id, new RestaurantEntity(id, restaurant));
    }

    public int fetchNewRestaurantID() {
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
        final var id = fetchNewMealID();
        meals.put(id, new MealEntity(id, meal));
    }

    public int fetchNewMealID() {
        return mealCounter++;
    }

    public MealEntityBuilder getMealBuilder() {
        return new MealEntityBuilder(this);
    }

    public Collection<MealEntity> listMeals(int restaurantID) {
        return meals.values().stream().filter(m -> m.restaurantID() == restaurantID).toList();
    }

    public boolean hasRestaurant(final int restaurantID) {
        return restaurants.containsKey(restaurantID);
    }

    public void updateRestaurantName(final int restaurantID, final String newName) {
        final var restaurant = restaurants.get(restaurantID);
        restaurants.put(restaurantID, new RestaurantEntity(restaurantID, new Restaurant(newName, restaurant.address(), restaurant.type())));
    }
}
