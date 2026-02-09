package lld.swiggy;

import lld.swiggy.manager.RestaurantManager;
import lld.swiggy.models.MenuItem;
import lld.swiggy.models.Restaurant;

public final class Swiggy {

    public Swiggy() {
        initializeRestaurants();
    }

    public static void initializeRestaurants() {
        Restaurant restaurant1 = new Restaurant("Bikaner", "Pune");
        restaurant1.addMenuItem(new MenuItem(1, "Tandoori Chicken", 100));
        restaurant1.addMenuItem(new MenuItem(2, "Chicken Biryani", 200));
        restaurant1.addMenuItem(new MenuItem(3, "Chicken Curry", 150));
        restaurant1.addMenuItem(new MenuItem(4, "Chicken Tandoori", 100));
        restaurant1.addMenuItem(new MenuItem(5, "Chicken Tikka", 100));
        restaurant1.addMenuItem(new MenuItem(6, "Chicken Karahi", 100));
        restaurant1.addMenuItem(new MenuItem(7, "Chicken Tikka", 100));
        restaurant1.addMenuItem(new MenuItem(8, "Chicken Karahi", 100));

        Restaurant restaurant2 = new Restaurant("Pizza Hut", "Mumbai");
        restaurant2.addMenuItem(new MenuItem(1, "Margherita Pizza", 100));
        restaurant2.addMenuItem(new MenuItem(2, "Cheese Pizza", 200));
        restaurant2.addMenuItem(new MenuItem(3, "Pepperoni Pizza", 150));
        restaurant2.addMenuItem(new MenuItem(4, "Veg Pizza", 100));
        restaurant2.addMenuItem(new MenuItem(5, "Chicken Pizza", 100));
        restaurant2.addMenuItem(new MenuItem(6, "Chicken Karahi", 100));
        restaurant2.addMenuItem(new MenuItem(7, "Chicken Tikka", 100));
        restaurant2.addMenuItem(new MenuItem(8, "Chicken Karahi", 100));

        Restaurant restaurant3 = new Restaurant("KFC", "Delhi");
        restaurant3.addMenuItem(new MenuItem(1, "Chicken Burger", 100));
        restaurant3.addMenuItem(new MenuItem(2, "Chicken Pizza", 200));
        restaurant3.addMenuItem(new MenuItem(3, "Chicken Curry", 150));
        restaurant3.addMenuItem(new MenuItem(4, "Chicken Tandoori", 100));
        restaurant3.addMenuItem(new MenuItem(5, "Chicken Tikka", 100));
        restaurant3.addMenuItem(new MenuItem(6, "Chicken Karahi", 100));
        restaurant3.addMenuItem(new MenuItem(7, "Chicken Tikka", 100));
        restaurant3.addMenuItem(new MenuItem(8, "Chicken Karahi", 100));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);

    }
}
