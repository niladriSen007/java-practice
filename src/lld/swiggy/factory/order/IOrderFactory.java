package lld.swiggy.factory.order;

import java.util.List;

import lld.swiggy.models.Cart;
import lld.swiggy.models.MenuItem;
import lld.swiggy.models.Restaurant;
import lld.swiggy.models.User;
import lld.swiggy.strategy.PaymentContext;

public interface IOrderFactory {

    IOrder createOrder();

    default void createAndProcessOrder(
            User user,
            Cart cart,
            Restaurant restaurant,
            List<MenuItem> menuItems,
            PaymentContext paymentContext,
            String orderType) {
        IOrder order = createOrder();
        order.createOrder(user, cart, restaurant, menuItems, paymentContext, orderType);
    }
}
