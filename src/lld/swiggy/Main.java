package lld.swiggy;

import java.util.List;

import lld.swiggy.models.MenuItem;
import lld.swiggy.models.Order;
import lld.swiggy.models.Restaurant;
import lld.swiggy.models.User;
import lld.swiggy.strategy.CreditCardPaymentStrategy;
import lld.swiggy.strategy.PaymentContext;

public class Main {
    public static void main(String[] args) {
        Swiggy swiggy = new Swiggy();
        User user = new User(1, "John Doe", "123 Main St, Anytown, USA");

        List<Restaurant> searchRestaurantsByLocation = swiggy.searchRestaurantsByLocation("Pune");
        for (Restaurant restaurant : searchRestaurantsByLocation) {
            System.out.println("Search results for restaurants in " + restaurant.getRestaurantAddress() + " is -  "
                    + restaurant.getRestaurantName());
        }

        user.getCart().setRestaurant(searchRestaurantsByLocation.get(0));
        user.getCart().addMenuItem(new MenuItem("1", "Item 1", 100));
        user.getCart().addMenuItem(new MenuItem("2", "Item 2", 200));
        user.getCart().addMenuItem(new MenuItem("3", "Item 3", 300));

        Order order = swiggy.createInstantOrder(user, "Delivery", new PaymentContext(new CreditCardPaymentStrategy()));
        swiggy.printUserCart(user);

        // Order scheduledOrder = swiggy.createScheduledOrder(user, "Delivery",
        // new PaymentContext(new CreditCardPaymentStrategy()), "2026-01-01 10:00:00");
        // swiggy.payForOrder(user, scheduledOrder);
        // swiggy.printUserCart(user);

        swiggy.payForOrder(user, order);
    }
}
