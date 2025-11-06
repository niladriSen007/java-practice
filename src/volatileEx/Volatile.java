package volatileEx;

class SharedResource {
    private boolean flag = false;

    public void setFlagToTrue() {
        flag = true;
    }

    public void printFlag() {
        while (!flag) {
        }
        System.out.println("Flag is true");
    }
}

public class Volatile {
    public static void main(String[] args) {
//        SharedResource
    }
}

