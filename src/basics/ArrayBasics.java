package basics;

public class ArrayBasics {
    static void main() {
        int[][] twoD = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int[] ints : twoD) {
            for (int anInt : ints) {
                System.out.print(STR."\{anInt} ");
            }
            System.out.println();
        }
        int[][] dyn = new int[2][2];
        dyn[0][0] = 10;
        dyn[0][1] = 20;
        dyn[1][0] = 30;
        dyn[1][1] = 40;
        for (int[] ints : dyn) {
            for (int anInt : ints) {
                System.out.print(STR."\{anInt} ");
            }
        }
    }
}
