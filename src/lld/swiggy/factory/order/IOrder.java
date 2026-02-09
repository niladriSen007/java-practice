package lld.swiggy.factory.order;

import java.util.List;

import lld.swiggy.models.Cart;
import lld.swiggy.models.MenuItem;
import lld.swiggy.models.Order;
import lld.swiggy.models.Restaurant;
import lld.swiggy.models.User;
import lld.swiggy.strategy.PaymentContext;

public interface IOrder {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
            PaymentContext paymentContext, String orderType);
}
