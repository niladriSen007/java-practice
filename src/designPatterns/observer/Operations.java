package designPatterns.observer;

public interface Operations {
    void addConsumer(Consumer consumer);

    void removeConsumer(Consumer consumer);

    void notifyConsumers();
}
