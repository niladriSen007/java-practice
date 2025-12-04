package coreJava;

import java.io.IOException;

class ParentNew {
    float test() throws ArithmeticException {
        return 5 / 0;
    }
}

class ChildNew extends ParentNew {
    float test() throws  ArithmeticException{
        System.out.println("Hii");
        return 10 / 0;
    }
}

//class Child2 extends ParentNew{
//    float test() throws  Exception{
//        System.out.println("Hii");
//        return 10 / 0;
//    }
//}

public class CanChildThrowException {
    public static void main(String[] args) {

    }
}
