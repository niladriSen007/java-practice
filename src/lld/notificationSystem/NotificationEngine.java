package lld.notificationSystem;

import java.util.ArrayList;
import java.util.List;

import lld.notificationSystem.factory.INotificationFactory;
import lld.notificationSystem.observer.NotificationObservable;

public class NotificationEngine {
    private final NotificationObservable notificationObservable;
    private final List<INotificationFactory> notificationFactories;

    public NotificationEngine() {
        this.notificationObservable = NotificationService.getInstance().getNotificationObservable();
        notificationFactories = new ArrayList<>();
    }

    public void addNotificationFactory(INotificationFactory factory) {
        this.notificationFactories.add(factory);
    }

    public void update() {
        String notificationContent = this.notificationObservable.getNotificationContent();
        for (INotificationFactory factory : notificationFactories) {
            factory.createNotificationWork().sendNotification(notificationContent);
        }
    }
}
