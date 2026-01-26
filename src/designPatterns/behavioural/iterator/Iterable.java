package designPatterns.behavioural.iterator;

public interface Iterable<T> {
    Iterator<T> getIterator();
}
