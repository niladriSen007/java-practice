package lld.notificationSystem.observer;

public interface INotificationObservable {
    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();
}
