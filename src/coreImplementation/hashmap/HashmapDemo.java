package coreImplementation.hashmap;

import java.util.LinkedList;

public class HashmapDemo {

    static int THRESHOLD_OF_K = 2;

    static class HashMap<K, V> {
        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<Node>();
            }
        }

        private int hashFunction(K key) {
            int bucketIndex = key.hashCode();
            return Math.abs(bucketIndex) % N;
        }

        private int searchIndexInLL(int bucketIndex, K key) {
            LinkedList<Node> bucket = buckets[bucketIndex];
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).key.equals(key)) return i;
            }
            return -1;
        }

        private void rehashing() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];

            //adding blank LL to the new bucket
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> llBucket = oldBucket[i];
                for (int j = 0; i < llBucket.size(); j++) {
                    Node node = llBucket.get(i);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int keyIndexInsideLL = searchIndexInLL(bucketIndex, key);
            if (keyIndexInsideLL < 0) { //key does not exist in the specified bucket index
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            } else {
                Node node = buckets[bucketIndex].get(keyIndexInsideLL);
                node.value = value;
            }
            double lambda = (double) n / N;
            if (lambda > THRESHOLD_OF_K) {
                rehashing();
            }
        }


        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

    }

    public static void main(String[] args) {
        HashMap<String,Integer> countries = new HashMap<>();
        countries.put("India",1);
        countries.put("Australia",2);
        countries.put("England",3);

    }
}
