package collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * SENIOR/STAFF LEVEL JAVA ARRAYLIST INTERVIEW QUESTIONS
 * 
 * This comprehensive guide covers advanced ArrayList concepts typically asked
 * in senior and staff-level technical interviews.
 */
public class ArrayListInterviewQuestions {

    /**
     * ============================================================================
     * SECTION 1: INTERNAL IMPLEMENTATION & ARCHITECTURE
     * ============================================================================
     */

    /**
     * Q1: Explain the internal data structure of ArrayList. How is data stored?
     * 
     * Answer:
     * - ArrayList internally uses a dynamically resizable array (Object[])
     * - Default initial capacity is 10 elements
     * - When capacity is exceeded, a new array is created with larger capacity
     * - Elements are stored contiguously in memory
     * - Maintains a 'size' field (actual elements) separate from capacity
     */

    /**
     * Q2: How does ArrayList handle capacity growth? What is the growth factor?
     * 
     * Answer:
     * - Growth factor is approximately 1.5x (newCapacity = oldCapacity +
     * (oldCapacity >> 1))
     * - When add() is called and size == capacity, a new array is allocated
     * - Old array elements are copied to new array using System.arraycopy()
     * - Growth strategy balances memory usage vs. reallocation frequency
     * - Can pre-allocate capacity using ensureCapacity(int) to avoid multiple
     * resizes
     */
    public static void demonstrateCapacityGrowth() {
        ArrayList<Integer> list = new ArrayList<>();
        // Initially capacity = 10

        // Pre-allocate to avoid resizing if you know the size
        list.ensureCapacity(1000);

        // trimToSize() reduces capacity to actual size to save memory
        list.trimToSize();
    }

    /**
     * Q3: What is the significance of the modCount field in ArrayList?
     * 
     * Answer:
     * - modCount is inherited from AbstractList
     * - Tracks number of structural modifications (add, remove, clear)
     * - Used for fail-fast behavior in iterators
     * - Each iterator stores expected modCount at creation time
     * - If list's modCount != iterator's expectedModCount, throws
     * ConcurrentModificationException
     * - Does NOT track non-structural modifications (set operation)
     */
    public static void demonstrateModCount() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        try {
            // This will throw ConcurrentModificationException
            for (Integer num : list) {
                if (num == 3) {
                    list.remove(num); // Structural modification during iteration
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
        }

        // Correct way: use Iterator.remove()
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num == 3) {
                iterator.remove(); // Safe removal
            }
        }
    }

    /**
     * ============================================================================
     * SECTION 2: THREAD SAFETY & CONCURRENCY
     * ============================================================================
     */

    /**
     * Q4: Is ArrayList thread-safe? How would you make it thread-safe?
     * 
     * Answer:
     * ArrayList is NOT thread-safe. Multiple solutions exist:
     * 
     * 1. Collections.synchronizedList(new ArrayList<>())
     * - Wraps ArrayList with synchronized methods
     * - Must manually synchronize during iteration
     * - Performance overhead on every operation
     * 
     * 2. CopyOnWriteArrayList
     * - All mutative operations create a fresh copy of underlying array
     * - Excellent for read-heavy scenarios
     * - Expensive for write-heavy scenarios
     * - Iterators never throw ConcurrentModificationException
     * 
     * 3. External synchronization using locks
     * - More fine-grained control
     * - Can use ReentrantReadWriteLock for read/write separation
     */
    public static void demonstrateThreadSafety() {
        // Option 1: Synchronized wrapper
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());

        // Must synchronize on list during iteration
        synchronized (syncList) {
            Iterator<String> it = syncList.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

        // Option 2: CopyOnWriteArrayList
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
        cowList.add("Thread-safe");
        cowList.add("No CME");

        // Iteration doesn't require synchronization
        for (String s : cowList) {
            System.out.println(s);
        }
    }

    /**
     * Q5: What is the difference between Vector and ArrayList regarding
     * synchronization?
     * 
     * Answer:
     * - Vector: All methods are synchronized (thread-safe but slower)
     * - ArrayList: No synchronization (faster but not thread-safe)
     * - Vector uses method-level synchronization (coarse-grained)
     * - ArrayList requires external synchronization if needed
     * - Vector is legacy class; ArrayList is preferred in modern Java
     * - Vector grows by 2x (or custom increment), ArrayList by ~1.5x
     */

    /**
     * ============================================================================
     * SECTION 3: PERFORMANCE & TIME COMPLEXITY
     * ============================================================================
     */

    /**
     * Q6: What are the time complexities of various ArrayList operations?
     * 
     * Answer:
     * - get(index): O(1) - Direct array access
     * - set(index, element): O(1) - Direct array access
     * - add(element): Amortized O(1) - O(n) when resizing needed
     * - add(index, element): O(n) - Requires shifting elements
     * - remove(index): O(n) - Requires shifting elements
     * - remove(Object): O(n) - Search + shift
     * - contains(Object): O(n) - Linear search
     * - indexOf(Object): O(n) - Linear search
     * - clear(): O(n) - Sets all elements to null for GC
     * - size(): O(1) - Returns size field
     * - isEmpty(): O(1) - Checks size == 0
     */

    /**
     * Q7: Why is adding elements at the beginning or middle of ArrayList slow?
     * 
     * Answer:
     * - Requires shifting all subsequent elements by one position
     * - Uses System.arraycopy() which is native and optimized but still O(n)
     * - Each shift operation is a memory copy
     * - For frequent insertions/deletions in middle, LinkedList may be better
     * - However, ArrayList's cache locality often makes it faster even for
     * insertions
     */
    public static void demonstrateInsertionPerformance() {
        List<Integer> list = new ArrayList<>();

        // Fast: O(1) amortized
        list.add(1);
        list.add(2);
        list.add(3);

        // Slow: O(n) - shifts all elements
        list.add(0, 0); // Insert at beginning

        // Slow: O(n) - shifts half the elements on average
        list.add(list.size() / 2, 99); // Insert in middle
    }

    /**
     * ============================================================================
     * SECTION 4: ITERATORS & FAIL-FAST BEHAVIOR
     * ============================================================================
     */

    /**
     * Q8: Explain fail-fast vs fail-safe iterators. Which does ArrayList use?
     * 
     * Answer:
     * - ArrayList uses FAIL-FAST iterators
     * - Fail-fast: Throws ConcurrentModificationException on structural
     * modification
     * during iteration (except through iterator's own remove/add methods)
     * - Implemented by checking modCount vs expectedModCount
     * - Fail-safe: Works on a clone/snapshot, never throws CME
     * (e.g., CopyOnWriteArrayList, ConcurrentHashMap)
     * - Fail-fast is best-effort, not guaranteed (don't rely on CME for
     * correctness)
     */

    /**
     * Q9: How would you safely remove elements while iterating an ArrayList?
     * 
     * Answer:
     * Three safe approaches:
     * 1. Use Iterator.remove()
     * 2. Use removeIf() method (Java 8+)
     * 3. Collect indices/elements to remove, then remove in separate pass
     */
    public static void demonstrateSafeRemoval() {
        // Approach 1: Iterator.remove()
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> it = list1.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove();
            }
        }

        // Approach 2: removeIf() - preferred in Java 8+
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list2.removeIf(num -> num % 2 == 0);

        // Approach 3: Collect and remove
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> toRemove = new ArrayList<>();
        for (Integer num : list3) {
            if (num % 2 == 0) {
                toRemove.add(num);
            }
        }
        list3.removeAll(toRemove);
    }

    /**
     * ============================================================================
     * SECTION 5: CLONING & SERIALIZATION
     * ============================================================================
     */

    /**
     * Q10: Explain ArrayList's clone() method. Is it deep copy or shallow copy?
     * 
     * Answer:
     * - ArrayList.clone() returns a SHALLOW COPY
     * - Creates a new ArrayList instance with new backing array
     * - But elements themselves are NOT cloned - same object references
     * - Modifying the list structure (add/remove) doesn't affect the clone
     * - Modifying element objects DOES affect both original and clone
     * - For deep copy, must manually clone each element
     */
    public static void demonstrateCloning() {
        class Person {
            String name;

            Person(String name) {
                this.name = name;
            }
        }

        ArrayList<Person> original = new ArrayList<>();
        original.add(new Person("Alice"));
        original.add(new Person("Bob"));

        @SuppressWarnings("unchecked")
        ArrayList<Person> cloned = (ArrayList<Person>) original.clone();

        // Structural change - doesn't affect clone
        original.add(new Person("Charlie"));
        System.out.println("Original size: " + original.size()); // 3
        System.out.println("Cloned size: " + cloned.size()); // 2

        // Modifying element - affects both!
        original.get(0).name = "Alice Modified";
        System.out.println("Cloned first person: " + cloned.get(0).name); // "Alice Modified"
    }

    /**
     * Q11: Is ArrayList serializable? What fields are serialized?
     * 
     * Answer:
     * - ArrayList implements Serializable
     * - Only the 'size' field and actual elements are serialized
     * - The backing array capacity is NOT serialized (optimizes space)
     * - On deserialization, array is reconstructed with size == capacity
     * - Custom serialization using writeObject/readObject methods
     * - Transient fields (like elementData array) are handled specially
     */

    /**
     * ============================================================================
     * SECTION 6: MEMORY & GC CONSIDERATIONS
     * ============================================================================
     */

    /**
     * Q12: How does ArrayList impact Garbage Collection?
     * 
     * Answer:
     * - Holds strong references to all elements
     * - Even after remove(), elements set to null to enable GC
     * - clear() method nulls out all elements to help GC
     * - Unused capacity can waste memory (use trimToSize() after bulk operations)
     * - Large ArrayLists can cause GC pressure if frequently resized
     * - Consider initial capacity if final size is known
     */
    public static void demonstrateMemoryOptimization() {
        // Wasteful - multiple resizes
        ArrayList<String> wasteful = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            wasteful.add("Item " + i);
        }

        // Optimized - single allocation
        ArrayList<String> optimized = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            optimized.add("Item " + i);
        }

        // Save memory after bulk removal
        optimized.clear();
        optimized.trimToSize(); // Reduces capacity to 0
    }

    /**
     * Q13: What happens to ArrayList when it's cleared? Does it release memory?
     * 
     * Answer:
     * - clear() sets size to 0 and nulls out all element references
     * - Backing array capacity remains the same (memory not released)
     * - Elements become eligible for GC since references are nulled
     * - To release memory, call trimToSize() after clear()
     * - Or set list = new ArrayList<>() to abandon old instance
     */

    /**
     * ============================================================================
     * SECTION 7: ADVANCED SCENARIOS & EDGE CASES
     * ============================================================================
     */

    /**
     * Q14: Can ArrayList contain null elements? What are the implications?
     * 
     * Answer:
     * - Yes, ArrayList can contain null elements (unlike TreeSet/TreeMap)
     * - Multiple nulls are allowed
     * - indexOf(null) returns first occurrence
     * - contains(null) returns true if any null exists
     * - Requires null checks when iterating to avoid NullPointerException
     * - remove(null) removes first null occurrence
     */
    public static void demonstrateNullHandling() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add(null);
        list.add("B");
        list.add(null);

        System.out.println("Contains null: " + list.contains(null)); // true
        System.out.println("First null at: " + list.indexOf(null)); // 1

        list.remove(null); // Removes first null
        System.out.println("Size after remove: " + list.size()); // 3
    }

    /**
     * Q15: How does ArrayList handle comparison and sorting?
     * 
     * Answer:
     * - ArrayList doesn't enforce any ordering
     * - Elements can be sorted using Collections.sort() or List.sort()
     * - Requires elements to be Comparable or provide a Comparator
     * - sort() uses TimSort algorithm (O(n log n) time, O(n) space)
     * - equals() compares size and elements in order using element.equals()
     * - hashCode() is computed from elements' hashCodes
     */
    public static void demonstrateSorting() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));

        // Natural ordering
        Collections.sort(numbers);
        // Or: numbers.sort(null);

        // Custom comparator
        numbers.sort(Comparator.reverseOrder());

        // Stream-based sorting (creates new list)
        List<Integer> sorted = numbers.stream()
                .sorted()
                .toList();
    }

    /**
     * Q16: What is the difference between ArrayList.subList() and creating a new
     * ArrayList?
     * 
     * Answer:
     * - subList() returns a VIEW, not a new ArrayList
     * - Changes to subList affect original list and vice versa
     * - subList is backed by original list (no element copying)
     * - Structural modifications to original list invalidate subList
     * - Using invalidated subList throws ConcurrentModificationException
     * - Memory efficient but requires careful usage
     * - To get independent copy: new ArrayList<>(list.subList(from, to))
     */
    public static void demonstrateSubList() {
        List<String> original = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));

        // View - changes affect original
        List<String> subList = original.subList(1, 4); // [B, C, D]
        subList.set(0, "Modified");
        System.out.println("Original: " + original); // [A, Modified, C, D, E]

        // Independent copy
        List<String> copy = new ArrayList<>(original.subList(1, 4));
        copy.set(0, "Changed");
        System.out.println("Original unchanged: " + original);
    }

    /**
     * ============================================================================
     * SECTION 8: COMPARISON WITH OTHER COLLECTIONS
     * ============================================================================
     */

    /**
     * Q17: When would you choose ArrayList over LinkedList?
     * 
     * Answer:
     * ArrayList is preferred when:
     * - Random access (get/set) is frequent: O(1) vs O(n)
     * - Memory efficiency matters: ArrayList has less overhead per element
     * - Iteration performance: ArrayList has better cache locality
     * - Size is relatively stable or grows at the end
     * 
     * LinkedList is preferred when:
     * - Frequent insertions/deletions at beginning/middle
     * - Acting as a queue/deque (offer, poll operations)
     * - No random access needed
     * - In practice, ArrayList often performs better even for insertions due to
     * cache
     */

    /**
     * Q18: How does ArrayList compare to CopyOnWriteArrayList?
     * 
     * Answer:
     * ArrayList:
     * - Not thread-safe
     * - Fast writes (no copying)
     * - Fail-fast iterators
     * - Best for single-threaded or externally synchronized scenarios
     * 
     * CopyOnWriteArrayList:
     * - Thread-safe
     * - Expensive writes (copies entire array)
     * - Never throws ConcurrentModificationException
     * - Ideal for read-heavy concurrent scenarios (event listeners, observers)
     * - Iterators operate on snapshot, don't reflect subsequent modifications
     */

    /**
     * ============================================================================
     * SECTION 9: JAVA 8+ FEATURES & FUNCTIONAL OPERATIONS
     * ============================================================================
     */

    /**
     * Q19: How do Stream operations on ArrayList differ from traditional loops?
     * 
     * Answer:
     * - Streams are lazy; intermediate operations don't execute until terminal
     * operation
     * - Streams can be parallelized easily using parallelStream()
     * - Streams are functional and declarative
     * - ArrayList's stream() is efficient (Spliterator knows size, supports
     * parallel split)
     * - Multiple passes over data may be less efficient than single loop
     * - Streams can't modify the source collection directly
     */
    public static void demonstrateStreamOperations() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // Filter and collect
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        // Parallel processing for large lists
        List<Integer> processed = numbers.parallelStream()
                .map(n -> n * 2)
                .toList();

        // forEach (terminal operation)
        numbers.forEach(System.out::println);

        // removeIf (modifies original)
        numbers.removeIf(n -> n > 5);
    }

    /**
     * Q20: Explain ArrayList's toArray() methods and their differences.
     * 
     * Answer:
     * - toArray(): Returns Object[] containing all elements
     * - toArray(T[] a): Returns T[] (typed array)
     * - If array size >= list size, elements are copied into provided array
     * - If array size < list size, new array of same type is allocated
     * - Remaining positions are set to null if array is larger
     * - toArray() is less type-safe but simpler
     * - toArray(T[]) is type-safe and can reuse array for efficiency
     */
    public static void demonstrateToArray() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));

        // Object array
        Object[] objArray = list.toArray();

        // Typed array - let method allocate
        String[] strArray1 = list.toArray(new String[0]);

        // Typed array - provide sized array
        String[] strArray2 = new String[list.size()];
        list.toArray(strArray2);

        // Java 11+ method reference
        String[] strArray3 = list.toArray(String[]::new);
    }

    /**
     * ============================================================================
     * SECTION 10: DESIGN & ARCHITECTURE QUESTIONS
     * ============================================================================
     */

    /**
     * Q21: If you were to implement your own ArrayList, what key aspects would you
     * consider?
     * 
     * Answer:
     * 1. Growth strategy (factor, maximum size)
     * 2. Thread safety requirements
     * 3. Memory efficiency (lazy initialization, capacity optimization)
     * 4. Iterator implementation (fail-fast, modCount tracking)
     * 5. Serialization support
     * 6. Null handling policy
     * 7. Bulk operation optimizations
     * 8. Integration with Collections framework
     */

    /**
     * Q22: Why does ArrayList implement RandomAccess interface?
     * 
     * Answer:
     * - RandomAccess is a marker interface (no methods)
     * - Signals that random access (get(i)) is O(1) and efficient
     * - Used by algorithms to choose optimal iteration strategy
     * - Example: Collections.binarySearch() checks for RandomAccess
     * - If RandomAccess: use index-based loop
     * - Otherwise: use iterator (better for LinkedList)
     * - Improves performance of generic algorithms
     */

    public static void main(String[] args) {
        System.out.println("=== ArrayList Senior/Staff Interview Questions Demo ===\n");

        System.out.println("1. Capacity Growth:");
        demonstrateCapacityGrowth();

        System.out.println("\n2. ModCount and ConcurrentModificationException:");
        demonstrateModCount();

        System.out.println("\n3. Thread Safety:");
        demonstrateThreadSafety();

        System.out.println("\n4. Insertion Performance:");
        demonstrateInsertionPerformance();

        System.out.println("\n5. Safe Removal:");
        demonstrateSafeRemoval();

        System.out.println("\n6. Cloning:");
        demonstrateCloning();

        System.out.println("\n7. Memory Optimization:");
        demonstrateMemoryOptimization();

        System.out.println("\n8. Null Handling:");
        demonstrateNullHandling();

        System.out.println("\n9. Sorting:");
        demonstrateSorting();

        System.out.println("\n10. SubList:");
        demonstrateSubList();

        System.out.println("\n11. Stream Operations:");
        demonstrateStreamOperations();

        System.out.println("\n12. ToArray:");
        demonstrateToArray();
    }
}
