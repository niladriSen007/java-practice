package dsa.binarySearch;

public class LastOccurance {

    public static int findLastOccurance(int[] arr, int target) { // 5, 7, 7, 8, 8, 10
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end >= 0 && arr[end] == target ? end : -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int res = findLastOccurance(arr, 8);
        System.out.println(res);
    }
}
