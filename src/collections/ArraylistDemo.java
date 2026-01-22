package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraylistDemo {
    public static void main(String[] args) {
        // List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7); // error
        // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7); // error
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        for (Integer num : list) {
            System.out.print(num + " ");
        }

        list.remove(Integer.valueOf(6)); // This will throw UnsupportedOperationException at runtime because List.of
                        // creates an immutable list

        list.add(9); // This will also throw UnsupportedOperationException at runtime
                     // because List.of creates an immutable list

        System.out.println("After removal:");
        for (Integer num : list) {
            System.out.println(num);
        }
    }
}

// If we initialize the list using Arrays.asList, the list is mutable, and we
// can add or remove elements.
// However, the size of the list is fixed, so we cannot add or remove elements
// that would change its size.

// If we initialize the list using List.of, the list is immutable, and any
// attempt to add or remove elements
// will result in an UnsupportedOperationException at runtime.

// Note: To create a fully mutable list, we can use ArrayList as follows:
/*
 * import java.util.ArrayList;
 * import java.util.List;
 * List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
 */