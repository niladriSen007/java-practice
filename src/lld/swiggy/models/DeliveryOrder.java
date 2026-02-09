package lld.swiggy.models;

public class DeliveryOrder extends Order {

    private String deliveryAddress;

    public DeliveryOrder() {
        this.deliveryAddress = "";
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String deliveryType() {
        return "Delivery";
    }

}
