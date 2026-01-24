package dsa.bit_manipulation;

public class BinaryToDecimal {

    public static int toDecimal(String bin) { // 1011 ->
        int len = bin.length();
        int sum = 0, pow = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                sum += pow;
            }
            pow *= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int decimal = toDecimal("1000");
        System.out.println(decimal);
    }
}
