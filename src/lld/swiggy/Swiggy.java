package lld.swiggy;

import java.util.List;

import designPatterns.creational.factory.good.EmailNotificationCreator;
import lld.swiggy.factory.order.IOrderFactory;
import lld.swiggy.factory.order.InstantOrderFactory;
import lld.swiggy.factory.order.ScheduledOrderFactory;
import lld.swiggy.manager.OrderManager;
import lld.swiggy.manager.RestaurantManager;
import lld.swiggy.models.Cart;
import lld.swiggy.models.MenuItem;
import lld.swiggy.models.Order;
import lld.swiggy.models.Restaurant;
import lld.swiggy.models.User;
import lld.swiggy.strategy.PaymentContext;

public final class Swiggy {

    public Swiggy() {
        initializeRestaurants();
    }

    public static void initializeRestaurants() {
        Restaurant restaurant1 = new Restaurant("Bikaner", "Pune");
        restaurant1.addMenuItem(new MenuItem("1", "Tandoori Chicken", 100));
        restaurant1.addMenuItem(new MenuItem("2", "Chicken Biryani", 200));
        restaurant1.addMenuItem(new MenuItem("3", "Chicken Curry", 150));
        restaurant1.addMenuItem(new MenuItem("4", "Chicken Tandoori", 100));
        restaurant1.addMenuItem(new MenuItem("5", "Chicken Tikka", 100));
        restaurant1.addMenuItem(new MenuItem("6", "Chicken Karahi", 100));

        Restaurant restaurant2 = new Restaurant("Pizza Hut", "Mumbai");
        restaurant2.addMenuItem(new MenuItem("1", "Margherita Pizza", 100));
        restaurant2.addMenuItem(new MenuItem("2", "Cheese Pizza", 200));
        restaurant2.addMenuItem(new MenuItem("3", "Pepperoni Pizza", 150));
        restaurant2.addMenuItem(new MenuItem("4", "Veg Pizza", 100));
        restaurant2.addMenuItem(new MenuItem("5", "Chicken Pizza", 100));
        restaurant2.addMenuItem(new MenuItem("6", "Chicken Karahi", 100));

        Restaurant restaurant3 = new Restaurant("KFC", "Delhi");
        restaurant3.addMenuItem(new MenuItem("1", "Chicken Burger", 100));
        restaurant3.addMenuItem(new MenuItem("2", "Chicken Pizza", 200));
        restaurant3.addMenuItem(new MenuItem("3", "Chicken Curry", 150));
        restaurant3.addMenuItem(new MenuItem("4", "Chicken Tandoori", 100));
        restaurant3.addMenuItem(new MenuItem("5", "Chicken Tikka", 100));
        restaurant3.addMenuItem(new MenuItem("6", "Chicken Karahi", 100));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);

    }

    public List<Restaurant> searchRestaurantsByLocation(String location) {
        return RestaurantManager.getInstance().searchRestaurantsByLocation(location);
    }

    public void addToCart(User user, String itemCode) {
        Restaurant res = user.getCart().getRestaurant();
        if (res == null) {
            System.out.println("No restaurant in cart");
            return;
        }
        for (MenuItem item : res.getMenuItems()) {
            if (item.getMenuItemId().equals(itemCode)) {
                user.getCart().addMenuItem(item);
                break;
            }
        }

    }

    public Order createInstantOrder(User user, String orderType, PaymentContext paymentContext) {
        return checkout(user, orderType, paymentContext, new InstantOrderFactory());
    }

    public Order createScheduledOrder(User user, String orderType, PaymentContext paymentContext,
            String scheduledTime) {
        return checkout(user, orderType, paymentContext, new ScheduledOrderFactory(scheduledTime));
    }

    public Order checkout(User user, String orderType, PaymentContext paymentContext, IOrderFactory orderFactory) {
        Cart cart = user.getCart();
        if (cart.isCartEmpty())
            return null;
        Restaurant orderedRestaurant = cart.getRestaurant();
        List<MenuItem> orderedMenuItems = cart.getMenuItems();

        Order createdOrder = orderFactory.createAndProcessOrder(user, cart, orderedRestaurant, orderedMenuItems,
                paymentContext, orderType);
        OrderManager.getInstance().addOrder(createdOrder);
        return createdOrder;
    }

    public void payForOrder(User user, Order order) {
        boolean processPayment = order.processPayment();

        EmailNotificationCreator emailNotificationSender = new EmailNotificationCreator();
        if (processPayment) {
            emailNotificationSender.send("Order paid successfully");
            System.out.println("Order paid successfully");
            user.getCart().clearCart();
        } else {
            emailNotificationSender.send("Order payment failed");
            System.out.println("Order payment failed");
        }
    }

    public void printUserCart(User user) {
        Cart cart = user.getCart();
        if (cart.isCartEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        System.out.println("Cart items:");
        for (MenuItem item : cart.getMenuItems()) {
            System.out.println(item.getMenuItemName() + " - " + item.getMenuItemPrice());
        }
        System.out.println("Total cost: " + cart.getTotalCost());
    }

}
