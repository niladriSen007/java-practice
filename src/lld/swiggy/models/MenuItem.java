package lld.swiggy.models;

public class MenuItem {
    private int menuItemId;
    private String menuItemName;
    private double menuItemPrice;

    public MenuItem(int menuItemId, String menuItemName, double menuItemPrice) {
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
        this.menuItemPrice = menuItemPrice;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public double getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public void setMenuItemPrice(double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

}
