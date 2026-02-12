package designpattertnsupgrade.behaviouraldp.observer;

public interface IChannel {
    void subscribe(ISubscriber subscriber);

    void unSubscribe(ISubscriber subscriber);

    void notifySubscribers();
}
