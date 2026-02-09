package lld.swiggy.models;

import java.util.ArrayList;
import java.util.List;

import lld.swiggy.strategy.PaymentContext;

public abstract class Order {
    private static int nextOrderId = 0;

    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> menuItems = new ArrayList<>();
    protected double totalCost;
    protected PaymentContext paymentContext;
    protected String scheduled;

    public Order() {
        this.orderId = ++nextOrderId;
        this.user = null;
        this.restaurant = null;
        this.totalCost = 0.0;
        this.paymentContext = null;
        this.scheduled = null;
    }

    public boolean processPayment() {
        if (paymentContext == null) {
            System.out.println("Payment context is not set");
            return false;
        }
        paymentContext.processPayment(totalCost);
        System.out.println("Payment processed successfully");
        return true;
    }

    public void setPaymentContext(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.totalCost = calculateTotalCost();
    }

    public double calculateTotalCost() {
        return menuItems.stream().mapToDouble(MenuItem::getMenuItemPrice).sum();
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void addItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
        this.totalCost += menuItem.getMenuItemPrice();
    }

    public void removeItem(MenuItem menuItem) {
        this.menuItems.remove(menuItem);
        this.totalCost -= menuItem.getMenuItemPrice();
    }

    public void clearItems() {
        this.menuItems.clear();
        this.totalCost = 0.0;
    }

    public abstract String deliveryType();

    public String getScheduled() {
        return scheduled;
    }

}
