package dsa.heap;

import java.util.PriorityQueue;

class Pair {
    int first;
    String second;

    public Pair(int first, String second) {
        this.first = first;
        this.second = second;
    }
}

public class PriorityQueuePair {
    public static void main(String[] args) {
        // min_heap at first and max_heap at second
        PriorityQueue<Pair> min_heap_atFirst_max_heap_atSecond = new PriorityQueue<>(
                (a, b) -> {
                    if (a.first != b.first)
                        return a.first - b.first; // a - b if value negative then a comes first -> min_heap
                    return b.second.compareTo(a.second); // b - a if value positive then b comes first -> max_heap
                }
        );

        // max_heap at first and min_heap at second
        PriorityQueue<Pair> max_heap_atFirst_min_heap_atSecond = new PriorityQueue<>(
                (a, b) -> {
                    if (a.first != b.first)
                        return b.first - a.first;
                    return a.second.compareTo(b.second);
                }
        );

        // min_heap at first and min_heap at second
        PriorityQueue<Pair> min_heap_atFirst_min_heap_atSecond = new PriorityQueue<>(
                (a, b) -> {
                    if (a.first != b.first)
                        return a.first - b.first;
                    return a.second.compareTo(b.second);
                }
        );

        // max_heap at first and max_heap at second
        PriorityQueue<Pair> max_heap_atFirst_max_heap_atSecond = new PriorityQueue<>(
                (a, b) -> {
                    if (a.first != b.first)
                        return b.first - a.first;
                    return b.second.compareTo(b.second);
                }
        );


    }
}
