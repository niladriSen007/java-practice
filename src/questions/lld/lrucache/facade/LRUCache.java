package questions.lld.lrucache.facade;

import questions.lld.lrucache.entity.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public V get(K key) {
        if (this.map.containsKey(key)) {
            Node<K, V> node = this.map.get(key);
            removeFromCurrentPosition(node);
            moveToFront(node);
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = this.map.get(key);
            node.value = value;
            removeFromCurrentPosition(node);
            moveToFront(node);
        }
        if (map.size() == this.capacity) {
            evictLeastRecentlyUsedKey();
        }
        Node<K, V> node = new Node<>(key, value);
        map.put(key, node);
        moveToFront(node);
    }

    private void moveToFront(Node<K, V> node) {
        node.next = this.head.next;
        this.head.next.prev = node;
        node.prev = this.head;
        this.head.next = node;
    }

    private void removeFromCurrentPosition(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void evictLeastRecentlyUsedKey() {
        Node<K, V> lastNode = this.tail.prev;
        removeFromCurrentPosition(lastNode);
        map.remove(lastNode.key);
    }

}
