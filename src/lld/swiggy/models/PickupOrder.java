package lld.swiggy.models;

public class PickupOrder extends Order {

    private String restaurantAddress;

    public PickupOrder() {
        this.restaurantAddress = "";
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    @Override
    public String deliveryType() {
        return "Pickup";
    }
}
