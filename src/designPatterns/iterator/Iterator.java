package designPatterns.iterator;

public interface Iterator<T> {
    boolean hasNext();

    T next();
}
