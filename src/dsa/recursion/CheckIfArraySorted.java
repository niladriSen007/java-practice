package dsa.recursion;

import java.util.Arrays;

public class CheckIfArraySorted {
    public static boolean ifArraySorted(int[] arr, int idx) {
        if (arr.length == 1) return true;
        if (arr[idx] > arr[idx - 1]) {
            return ifArraySorted(Arrays.copyOfRange(arr, 0, idx ), idx - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 33, 4, 5};
        System.out.println(ifArraySorted(arr, arr.length - 1));
    }
}
