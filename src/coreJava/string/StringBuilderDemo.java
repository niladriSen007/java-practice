package coreJava.string;

public class StringBuilderDemo {
    static void main() {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb.reverse());
        System.out.println(sb);

        long startTime, endTime;

        startTime = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += "Hello";
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total time" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder("");
        sb2.append("Hello".repeat(100000));
        endTime = System.currentTimeMillis();
        System.out.println("Total time" + (endTime - startTime) + "ms");
    }
}
