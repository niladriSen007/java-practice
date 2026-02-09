package lld.swiggy.manager;

import java.util.ArrayList;
import java.util.List;

import lld.swiggy.models.Restaurant;

public class RestaurantManager {

    private final List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager restaurantManager = null;

    private RestaurantManager() {
    }

    @SuppressWarnings("DoubleCheckedLocking")
    public static RestaurantManager getInstance() {
        if (restaurantManager == null) {
            synchronized (RestaurantManager.class) {
                if (restaurantManager == null) {
                    restaurantManager = new RestaurantManager();
                }
            }
        }
        return restaurantManager;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void removeRestaurant(Restaurant restaurant) {
        restaurants.remove(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant getRestaurant(int restaurantId) {
        return restaurants.stream().filter(restaurant -> restaurant.getRestaurantId() == restaurantId).findFirst()
                .orElse(null);
    }

    public List<Restaurant> searchRestaurantsByLocation(String location) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getRestaurantAddress().toLowerCase().contains(location.toLowerCase()))
                .toList();
    }

}
