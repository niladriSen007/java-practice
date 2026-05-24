package dsa.recursion.printsubsequence;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequenceWithTargetSum {
    static int sum = 0;

    static void printSubSequence(int index, List<Integer> arr, List<Integer> res, int target) {
        if (index >= arr.size()) {
            if (sum == target) {
                System.out.println(res.toString());
            }
            return;
        }
        res.add(arr.get(index));
        sum += arr.get(index);
        printSubSequence(index + 1, arr, res, target);
        Integer i = res.removeLast();
        sum -= Integer.valueOf(i);
        printSubSequence(index + 1, arr, res, target);
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(3, 1, 1, 2);
        printSubSequence(0, integers, new ArrayList<Integer>(), 2);
    }
}
