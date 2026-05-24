package dsa.recursion.printsubsequence;

import java.util.ArrayList;
import java.util.List;

public class CountSubsequenceWithSumK {
    static int sum = 0;

    static int countSubsequence(int index, List<Integer> actual, List<Integer> arr, int target) {
        if (index >= actual.size()) {
            if (sum == target) return 1;
            return 0;
        }
        arr.add(actual.get(index));
        sum += actual.get(index);
        int left = countSubsequence(index + 1, actual, arr, target);
        Integer last = arr.removeLast();
        sum -= last;
        int right = countSubsequence(index + 1, actual, arr, target);
        return left + right;
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(3, 2, 1);
        int res = countSubsequence(0, integers, new ArrayList<>(), 3);
        System.out.println(res);
    }
}
    