package intr;

import java.util.Arrays;
import java.util.List;

public class Interview {
    public static void main(String[] args) {
//        input - aaaabbbdddddddcccccccccddd
//        output - ccccccccc

        String p = "abaaabbbdddddddcccccccccddd";
        List<String> list = Arrays.stream(p.split("")).toList();
//        System.out.println(list.stream().collect(
//                Collectors.groupingBy(
//                        Function.identity(),
//                        LinkedHashMap
//                )
//        ));

        int count = 0;
        int maxCount = 0;
        String res = "";

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                count++;
                if (maxCount < count){
                    res = list.get(i);
                    maxCount++;
                }
            } else {
                count = 0;
            }
        }

        System.out.println(res);
        System.out.println(maxCount);

    }
}
