package dsa.recursion.recursiontwopointer;

public class ReverseArray {
    static void swap(int left, int[] arr) {
        int right = arr.length - left - 1;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static int[] reverseArray(int left, int[] arr) {
        if (left >= (arr.length / 2))
            return arr;
        swap(left, arr);
        return reverseArray(left + 1, arr);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] res = reverseArray(0, arr);
        for (int elem : res) {
            System.out.println(elem);
        }
    }
}
