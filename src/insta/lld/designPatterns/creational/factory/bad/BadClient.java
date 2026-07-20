package insta.lld.designPatterns.creational.factory.bad;

enum BadNotificationType {
    EMAIL,
    SMS,
    IN_APP,
    PUSH_NOTIFICATION
}

class BadEmailNotification {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}

class BadSmsNotification {
    public void send() {
        System.out.println("Sending Sms Notification");
    }
}

class BadNotificationService {
    public void sendNotification(BadNotificationType type) {
        if (type == BadNotificationType.EMAIL) {
            BadEmailNotification email = new BadEmailNotification();
            email.send();
        } else if (type == BadNotificationType.SMS) {
            BadSmsNotification sms = new BadSmsNotification();
            sms.send();
        }
        // SO on ....
    }
}

public class BadClient {
    public static void main(String[] args) {
        BadNotificationService ns = new BadNotificationService();
        // Email Notification
        ns.sendNotification(BadNotificationType.EMAIL);
        // Sms Notification
        ns.sendNotification(BadNotificationType.SMS);
    }
}
