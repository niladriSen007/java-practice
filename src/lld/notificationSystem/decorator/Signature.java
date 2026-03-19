package lld.notificationSystem.decorator;

public class Signature extends NotificationDecorator {

    private final String signature;

    public Signature(INotification notification, String sign) {
        super(notification);
        this.signature = sign;
    }

    @Override
    public String getContent() {
        return notification.getContent() + "\n" + this.signature + "\n";
    }

}
