package coreJava;

public class OverloadingNull {

    static void test(String s) {
        System.out.println("String ->" + s);
    }

    static void test(StringBuffer s) {
        System.out.println("StringBuffer ->" + s);
    }
    static void test(Integer i) {
        System.out.println("Integer ->" + i);
    }

    static void test(Object o) {
        System.out.println("Object ->" + o);
    }

    public static void main(String[] args) {
        OverloadingNull.test((Integer) null);
    }
}
