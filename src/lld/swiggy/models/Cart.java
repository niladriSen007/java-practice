package lld.swiggy.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private final List<MenuItem> menuItems = new ArrayList<>();

    public Cart() {
        this.restaurant = null;
    }

    public void addMenuItem(MenuItem menuItem) {
        if (restaurant == null) {
            throw new RuntimeException("Restaurant not set");
        }
        menuItems.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem) {
        menuItems.remove(menuItem);
    }

    public double getTotalCost() {
        return menuItems.stream().mapToDouble(menuItem -> menuItem.getMenuItemPrice()).sum();
    }

    public boolean isCartEmpty() {
        return restaurant == null || menuItems.isEmpty();
    }

    public void clearCart() {
        menuItems.clear();
        restaurant = null;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

}
