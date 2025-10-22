package array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {12, 3};
//        int[][] ints = rotateArrayByk(a, b);
//        for (int[] x : ints) {
//            System.out.println(Arrays.toString(x));
//        }
        usingPreProcessing(a, b);
    }

    //Brute force - Time Complexity: O(n*k)*m
    static int[][] rotateArrayByk(int actualArr[], int[] k) {
        int result[][] = new int[k.length][actualArr.length];
        for (int x = 0; x < k.length; x++) {
            int arr[] = actualArr.clone();
            for (int i = 0; i < k[x]; i++) {
                int temp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = temp;
            }
            result[x] = arr;
        }
        return result;
    }

    // Using Pre processor method
    static void usingPreProcessing(int actualArr[], int k[]) {
        int result[][] = new int[k.length][actualArr.length];
        int temp[] = new int[2 * actualArr.length];
        for (int i = 0; i < actualArr.length; i++) {
            temp[i] = actualArr[i];
            temp[i + actualArr.length] = actualArr[i];
        }
        for (int i = 0; i < k.length; i++) {
            int rotation = k[i] % actualArr.length;
            for (int j = 0; j < actualArr.length; j++) {
                result[i][j] = temp[j + rotation];
            }
        }

        for (int[] x : result) {
            System.out.println(Arrays.toString(x));
        }

    }

}
