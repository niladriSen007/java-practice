package designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Station implements Operations {

    private float temperature;
    private List<Consumer> consumers;

    Station() {
        consumers = new ArrayList<>();
    }

    public void updateTemperature(float temperature) {
        this.temperature = temperature;
        notifyConsumers();
    }

    @Override
    public void addConsumer(Consumer consumer) {
        consumers.add(consumer);
    }

    @Override
    public void removeConsumer(Consumer consumer) {
        consumers.remove(consumer);
    }

    @Override
    public void notifyConsumers() {
        consumers.forEach(consumer -> {
            consumer.update(temperature);
        });
    }
}
