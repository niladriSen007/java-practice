package lld.swiggy;

import java.util.List;

import lld.swiggy.models.Order;
import lld.swiggy.models.Restaurant;
import lld.swiggy.models.User;
import lld.swiggy.strategy.CreditCardPaymentStrategy;
import lld.swiggy.strategy.PaymentContext;

public class Main {
    public static void main(String[] args) {
        Swiggy swiggy = new Swiggy();
        User user = new User(1, "John Doe", "123 Main St, Anytown, USA");
        swiggy.addToCart(user, "1");
        swiggy.addToCart(user, "2");
        swiggy.addToCart(user, "3");
        swiggy.printUserCart(user);

        List<Restaurant> searchRestaurantsByLocation = swiggy.searchRestaurantsByLocation("Pune");
        for (Restaurant restaurant : searchRestaurantsByLocation) {
            System.out.println(restaurant.getRestaurantName() + " - " + restaurant.getRestaurantAddress());
        }

        Order order = swiggy.createInstantOrder(user, "Delivery", new PaymentContext(new CreditCardPaymentStrategy()));
        swiggy.payForOrder(user, order);
        swiggy.printUserCart(user);

        // Order scheduledOrder = swiggy.createScheduledOrder(user, "Delivery",
        // new PaymentContext(new CreditCardPaymentStrategy()), "2026-01-01 10:00:00");
        // swiggy.payForOrder(user, scheduledOrder);
        // swiggy.printUserCart(user);

        swiggy.payForOrder(user, order);
    }
}
