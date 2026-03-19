package lld.notificationSystem.observer;

import java.util.HashSet;
import java.util.Set;

import lld.notificationSystem.decorator.INotification;

public class NotificationObservable implements INotificationObservable {

    private final Set<IObserver> observers = new HashSet<>();
    private INotification notification;

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public void setNotification(INotification notification) {
        this.notification = notification;
        notifyObservers();
    }

    public INotification getNotification() {
        return this.notification;
    }

    public String getNotificationContent() {
        return notification.getContent();
    }

}
