package lld.notificationSystem.decorator;

public class SimpleNotification implements INotification {
    private final String text;

    public SimpleNotification(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return "Simple Notification - " + text;
    }
}
