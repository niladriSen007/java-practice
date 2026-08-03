package questions.lld.lrucache;

import questions.lld.lrucache.facade.LRUCache;

public class LRUClient {
    public static void main(String[] args) {
        LRUCache<String,String> cache = new LRUCache<>(2);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        System.out.println(cache.get("key3"));
    }
}
