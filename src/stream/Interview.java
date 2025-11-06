package stream;

import java.util.Arrays;
import java.util.List;

public class Interview {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().map(x->x*5).toList());
    }


}
