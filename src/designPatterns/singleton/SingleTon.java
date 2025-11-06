package designPatterns.singleton;

public class SingleTon {
    private static volatile SingleTon instance;

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
