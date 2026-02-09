package lld.swiggy.manager;

import java.util.ArrayList;
import java.util.List;

import lld.swiggy.models.Order;

public class OrderManager {

    private static OrderManager orderManager = null;
    private final List<Order> orders = new ArrayList<>();

    private OrderManager() {
    }

    public static OrderManager getInstance() {
        if (orderManager == null) {
            synchronized (OrderManager.class) {
                if (orderManager == null) {
                    orderManager = new OrderManager();
                }
            }
        }
        return orderManager;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void listOrders() {
        System.out.println("\n--- All Orders ---");
        for (Order order : orders) {
            System.out.println(order.deliveryType() + " order for " + order.getUser()
                    + " | Total: ₹" + order.getTotalCost()
                    + " | At: " + order.getScheduled());
        }
    }
}
