package dsa;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeativeChar {

    public static void main(String[] args) {
        String text = "swiwss";
        char c = firstNonRepeatingChar(text);
        System.out.println(c);
    }

    public static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> elem : map.entrySet()) {
            if (elem.getValue() == 1) {
                return elem.getKey();
            }
        }
        return '_';
    }
}
