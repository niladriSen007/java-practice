package lld.notificationSystem.observer;

import lld.notificationSystem.NotificationService;

public class Logger implements IObserver {

    private final NotificationObservable notificationObservable;

    public Logger() {
        this.notificationObservable = NotificationService.getInstance().getNotificationObservable();
        this.notificationObservable.addObserver(this);
    }

    public Logger(NotificationObservable notification) {
        this.notificationObservable = notification;
        notification.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Logging notification: " + this.notificationObservable.getNotificationContent());
    }

}
