package basics.methodReference;

import java.util.Collections;
import java.util.List;

public class MethodRef {
    static void main() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        Collections.sort(names,(a, b) -> a.compareToIgnoreCase(b));
        Collections.sort(names,String::compareToIgnoreCase);
        names.sort(String::compareToIgnoreCase);
    }
}
