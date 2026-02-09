package lld.swiggy.factory.notification;

public class EmailNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }

}
