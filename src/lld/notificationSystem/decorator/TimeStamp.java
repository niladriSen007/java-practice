package lld.notificationSystem.decorator;

public class TimeStamp extends NotificationDecorator {

    public TimeStamp(INotification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "[2025-04-13 14:22:00] " + notification.getContent();
    }

}
