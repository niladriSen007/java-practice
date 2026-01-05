package basics.methodReference;

import java.util.List;

class ToLower {
    public void toLower(String name) {
        System.out.println(name.toLowerCase());
    }
}

public class InstanceMethod {
    static void main() {
        List<String> names = List.of("alice", "bob", "charlie");
        ToLower toLower = new ToLower();
        names.forEach(toLower::toLower);
    }
}

