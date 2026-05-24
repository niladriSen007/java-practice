package dsa.recursion.printsubsequence;

import java.util.ArrayList;
import java.util.List;

public class PrintOneSubsequenceWithTargetSum {
    static int sum = 0;

    static boolean printSubSequence(int index, List<Integer> arr, List<Integer> res, int target) {
        if (index >= arr.size()) {
            if (sum == target) {
                System.out.println(res.toString());
                return true;
            }
            return false;
        }
        res.add(arr.get(index));
        sum += arr.get(index);
        if (printSubSequence(index + 1, arr, res, target)) return true;
        Integer i = res.removeLast();
        sum -= Integer.valueOf(i);
        if (printSubSequence(index + 1, arr, res, target)) return true;
        return false;
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(3, 1,2);
        if(!printSubSequence(0, integers, new ArrayList<Integer>(), 2)){
            System.out.println("No target subsequence available");
        }
    }
}
