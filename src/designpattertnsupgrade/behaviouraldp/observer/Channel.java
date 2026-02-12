package designpattertnsupgrade.behaviouraldp.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements IChannel {

    private final List<ISubscriber> subscribers;
    private final String name;
    private String latestVideo;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void notifySubscribers() {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    @Override
    public void unSubscribe(ISubscriber subscriber) {
        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        }
    }

    public void uploadVideo(String title) {
        latestVideo = title;
        System.out.println(this.name + " has uploaded " + latestVideo);
        notifySubscribers();
    }

    public String getVideoData() {
        return "Checkout our new video - " + latestVideo;
    }

}
