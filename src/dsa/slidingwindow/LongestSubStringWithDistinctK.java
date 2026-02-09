package dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithDistinctK {
    public static int longestKSubstr(String s, int k) {
        int n = s.length();
        int low = 0, high = 0;
        int max_length = -1;
        Map<Character, Integer> count = new HashMap<>();
        while (high < n) {
            count.put(s.charAt(high), count.getOrDefault(s.charAt(high), 0) + 1);
            if (count.size() == k) {
                max_length = Math.max(max_length, high - low + 1);
            }
            while (count.size() > k) {
                count.compute(s.charAt(low), (key, val) -> val == 1 ? null : val - 1);
                low++;
            }
            high++;
        }
        return max_length;
    }

    public static void main(String[] args) {
        int res = longestKSubstr("aabaaab", 2);
        System.out.println(res);
    }
}
