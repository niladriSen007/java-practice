package coreJava.generics;


class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


public class GenericsDemo {

    public static <K, V> Pair<K, V> createPair(K key, V value) {
        return new Pair<>(key, value);
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + ",");
        }
        System.out.println();
    }

    static void main() {
        printArray(new Integer[]{1, 2, 3, 4, 5});
        printArray(new String[]{"Hello", "World", "Generics"});
        printArray(new Double[]{1.1, 2.2, 3.3});

        Pair<String, Integer> pair = createPair("Age", 30);
        System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
    }
}
