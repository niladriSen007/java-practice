package designpattertnsupgrade.creationaldp.factory;

public class SmsNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }

}
