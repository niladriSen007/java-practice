package designpattertnsupgrade.behaviouraldp.observer;

public class Client {
    public static void main(String[] args) {
        Channel channel = new Channel("Chai aur code");

        Subscriber subscriber1 = new Subscriber("Nil", channel);
        Subscriber subscriber2 = new Subscriber("Paramita", channel);

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        channel.uploadVideo("React js in 1 video");

        channel.unSubscribe(subscriber2);

        channel.uploadVideo("Node js in 1 video");

    }
}
