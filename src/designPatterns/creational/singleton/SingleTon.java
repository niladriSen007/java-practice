package designPatterns.creational.singleton;

public class SingleTon {
    private static volatile SingleTon instance = null;

    private SingleTon() {
    }

    public SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
