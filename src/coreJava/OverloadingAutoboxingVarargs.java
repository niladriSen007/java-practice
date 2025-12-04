package coreJava;

public class OverloadingAutoboxingVarargs {
    static void test(int number) {
        System.out.println("int ->" + number);
    }

    static void test(Integer number) {
        System.out.println("Integer ->" + number);
    }

    static void test(Long number) {
        System.out.println("Long ->" + number);
    }

    static void test(int... number) {
        System.out.println("varargs int... ->" + number[0]);
    }

    public static void main(String[] args) {
        OverloadingAutoboxingVarargs.test(10);
        OverloadingAutoboxingVarargs.test(10L);
        OverloadingAutoboxingVarargs.test(Integer.valueOf(10));
        OverloadingAutoboxingVarargs.test(10, 20, 30);
        OverloadingAutoboxingVarargs.test(new int[]{1, 2});
    }
}


//"""
//| `m(10);`                  | `m(int)`           | exact match wins                    |
//| `m(10L);`                 | `m(long)`          | long literal matches long           |
//| `m(Integer.valueOf(10));` | `m(Integer)`       | Integer object matches              |
//| `m();`                    | `m(int...)`        | varargs accepts 0 args              |
//| `m(1,2,3);`               | `m(int...)`        | only varargs can take multiple ints |
//
//"""