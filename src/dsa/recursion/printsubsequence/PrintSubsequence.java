package dsa.recursion.printsubsequence;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence {

    static void printSubSequence(int index, List<Integer> arr, List<Integer> res) {
        if (index >= arr.size()) {
            System.out.println(res.toString());
            return;
        }
        res.add(arr.get(index));
        printSubSequence(index + 1, arr, res);
        res.removeLast();
        printSubSequence(index + 1, arr, res);
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(3, 1, 2);
        printSubSequence(0, integers, new ArrayList<Integer>());
    }
}
