package basics.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArrayClass {
    static void main() {
        // sort the array in ascending and descending order
        int[] arr = {4, 1, 2, 3, 5};
        Arrays.sort(arr);
        Integer[] arr2 = {4, 1, 2, 3, 5};
        Arrays.sort(arr2, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.binarySearch(arr, 4));


        // fill the array with a specific value
        int[] arr3 = new int[5];
        Arrays.fill(arr3, 7);
        System.out.println(Arrays.toString(arr3));
        int[] arr4 = new int[10];
        Arrays.fill(arr4,2, 5, 8); // fill from index 2 to 4 with 8
        System.out.println(Arrays.toString(arr4));

        //compare two arrays
        int[] arr5 = {1, 2, 3};
        int[] arr6 = {1, 2, 3};
        System.out.println(Arrays.equals(arr5, arr6)); // true

        // compare object arrays
        Integer[] arr7 = {1, 2, 3};
        Integer[] arr8 = {1, 2, 3};
        System.out.println(Arrays.equals(arr7, arr8)); // true

        //arrays to string
        System.out.println(Arrays.toString(arr5));

        //string to array
        String str = "hello,world,java";
        String[] strArr = str.split(",");
        System.out.println(Arrays.toString(strArr));
        String name="Niladri";
        String[] split = name.split("");
        char[] charArray = name.toCharArray();
        System.out.println(Arrays.toString(split));
        System.out.println(Arrays.toString(charArray));
    }
}
