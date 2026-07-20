package insta.lld.designPatterns.creational.factory.best;

enum BestNotificationType {
    EMAIL,
    SMS,
//    IN_APP,
//    PUSH_NOTIFICATION
}

interface BestNotification {
    void send();
}

class BestEmailNotification implements BestNotification {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}

class BestSmsNotification implements BestNotification {
    public void send() {
        System.out.println("Sending Sms Notification");
    }
}

// Factory
interface NotificationFactory {
    BestNotification createNotification();

    default void send() {
        BestNotification notification = createNotification();
        notification.send();
    }
}

class BestEmailNotificationFactory implements NotificationFactory {
    @Override
    public BestNotification createNotification() {
        return new BestEmailNotification();
    }
}

class BestSmsNotificationFactory implements NotificationFactory {
    @Override
    public BestNotification createNotification() {
        return new BestSmsNotification();
    }
}


public class BestClient {
    public static void main(String[] args) {

        NotificationFactory factory;

        factory = new BestEmailNotificationFactory();
        factory.send();

        factory = new BestSmsNotificationFactory();
        factory.send();
    }
}
