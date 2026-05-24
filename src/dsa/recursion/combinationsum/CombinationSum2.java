package dsa.recursion.combinationsum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {
    static int sum = 0;
    static Set<List<Integer>> resultSet = new HashSet<>();

    static void combinationSum(int index, List<Integer> res, List<Integer> arr, int target) {
        if (index >= arr.size()) {
            if (target == 0) {
                resultSet.add(new ArrayList<>(res));
                return;
            } else if (target < 0) {
                return;
            }
            return;
        }
        res.add(arr.get(index));
        sum += arr.get(index);
        int newTarget = target - arr.get(index);
        combinationSum(index + 1, res, arr, newTarget);
        Integer last = res.removeLast();
        sum -= last;
        newTarget = newTarget + last;
        combinationSum(index + 1, res, arr, newTarget);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(10, 1, 2, 7, 6, 1, 5);
        combinationSum(0, new ArrayList<>(), list, 8);
        System.out.println(resultSet.toString());
    }
}
