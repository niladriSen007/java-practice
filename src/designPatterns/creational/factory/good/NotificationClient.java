package designPatterns.creational.factory.good;

public class NotificationClient {
    public static void main() {
        NotificationCreator creator;

        // Send an email notification
        creator = new EmailNotificationCreator();
        creator.send("Hello via Email!");

        // Send an SMS notification
        creator = new SMSNotificationCreator();
        creator.send("Hello via SMS!");
    }
}
