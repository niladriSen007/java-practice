package basics;

import java.util.Arrays;

public class ArrayCopy {
    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] copyArr = new int[arr.length];

        //manual copy
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }

        // using System.arraycopy
        int[] copyArr2 = new int[arr.length];
        System.arraycopy(arr, 0, copyArr2, 0, arr.length);
        System.out.println(Arrays.toString(copyArr2));

        //using Arrays.copyOf
        int[] copyArr3 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(copyArr3));

        //larger size copy
        int[] copyArr4 = Arrays.copyOf(arr, arr.length + 5);
        System.out.println(Arrays.toString(copyArr4));

        // using clone method
        int[] copyArr5 = arr.clone();
        System.out.println(Arrays.toString(copyArr5));
    }
}
