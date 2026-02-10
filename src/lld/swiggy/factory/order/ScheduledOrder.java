package lld.swiggy.factory.order;

import java.util.List;

import lld.swiggy.models.Cart;
import lld.swiggy.models.DeliveryOrder;
import lld.swiggy.models.MenuItem;
import lld.swiggy.models.Order;
import lld.swiggy.models.PickupOrder;
import lld.swiggy.models.Restaurant;
import lld.swiggy.models.User;
import lld.swiggy.strategy.PaymentContext;

public class ScheduledOrder implements IOrder {

    private final String scheduledTime;

    public ScheduledOrder(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
            PaymentContext paymentContext, String orderType) {

        Order order = null;

        if (orderType.equalsIgnoreCase("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setDeliveryAddress(user.getUserAddress());
            order = deliveryOrder;
        } else if (orderType.equalsIgnoreCase("Pickup")) {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getRestaurantAddress());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setMenuItems(menuItems);
        order.setPaymentContext(paymentContext);
        order.setScheduled(this.scheduledTime);
        return order;
    }
}
