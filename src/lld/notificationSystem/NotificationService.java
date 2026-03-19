package lld.notificationSystem;

import java.util.ArrayList;
import java.util.List;

import lld.notificationSystem.decorator.INotification;
import lld.notificationSystem.observer.NotificationObservable;

public class NotificationService {
    private NotificationObservable notificationObservable;
    private static NotificationService instance = null;
    private List<INotification> notifications = new ArrayList<>();

    private NotificationService() {
        this.notificationObservable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationObservable getNotificationObservable() {
        return this.notificationObservable;
    }

    public void sendAnsStoreNotification(INotification notification) {
        notifications.add(notification);
        this.getNotificationObservable().setNotification(notification);
    }

}
