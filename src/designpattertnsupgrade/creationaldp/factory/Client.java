package designpattertnsupgrade.creationaldp.factory;

public class Client {
    public static void main(String[] args) {
        NotificationCreator creator;

        creator = new EmailNotificationCreator();
        creator.sendNotification("Hello via Email!");

        creator = new SmsNotificationCreator();
        creator.sendNotification("Hello via SMS!");
    }
}
