package dsa.recursion.combinationsum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    static int sum = 0;

    static void combinationSum(int index, List<Integer> res, List<Integer> arr, int target) {
        if (index >= arr.size()) return;
        else {
            if (target == 0) {
                System.out.println(res.toString());
                return;
            } else if (target < 0) {
                return;
            }
        }

        res.add(arr.get(index));
        sum += arr.get(index);
        int newTarget = target - arr.get(index);
        combinationSum(index, res, arr, newTarget);
        Integer last = res.removeLast();
        sum -= last;
        newTarget = newTarget + last;
        combinationSum(index + 1, res, arr, newTarget);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 7);
        combinationSum(0, new ArrayList<>(), list, 7);
    }
}
