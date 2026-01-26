package dsa.binarySearch;

public class FirstOccurance {

    public static int findFirstOccurance(int[] arr, int target) { // 0 1 1 2 3
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start < arr.length && arr[start] == target ? start : -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int res = findFirstOccurance(arr, 6);
        System.out.println(res);
    }
}
