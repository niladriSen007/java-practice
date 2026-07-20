package insta.lld.designPatterns.creational.factory.better;

enum BetterNotificationType {
    EMAIL,
    SMS,
//    IN_APP,
//    PUSH_NOTIFICATION
}

interface BetterNotification {
    void send();
}

class BetterEmailNotification implements BetterNotification {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}

class BetterSmsNotification implements BetterNotification {
    public void send() {
        System.out.println("Sending Sms Notification");
    }
}


class SimpleNotificationFactory {
    public static BetterNotification createNotification(BetterNotificationType type) {
        return switch (type) {
            case EMAIL -> new BetterEmailNotification();
            case SMS -> new BetterSmsNotification();
            // so on ...
        };
    }
}

class BetterNotificationService {
    public void send(BetterNotificationType type) {
        BetterNotification notification = SimpleNotificationFactory.createNotification(type);
        notification.send();
    }
}

public class BetterClient {
    public static void main(String[] args) {
        BetterNotificationService notificationService = new BetterNotificationService();
        // Email Notification
        notificationService.send(BetterNotificationType.EMAIL);
        // Sms Notification
        notificationService.send(BetterNotificationType.SMS);
    }
}
