package designPatterns.creational.singleton;

public class LazyInitialization {
    private static LazyInitialization lazyInitializationInstance;

    private LazyInitialization() {
    }

    public static LazyInitialization getLazyInitializationInstance() {
        if (lazyInitializationInstance == null) {
            lazyInitializationInstance = new LazyInitialization();
        }
        return lazyInitializationInstance;
    }
}
