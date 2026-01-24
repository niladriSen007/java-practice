package dsa.bit_manipulation;

public class DecimalToBinary {
    public static StringBuilder toBinary(int dec) { // 11 -> 1011
        StringBuilder res = new StringBuilder();
        while (dec > 0) {
            if (dec % 2 == 1)
                res.append("1");
            else
                res.append("0");
            dec = dec / 2;
        }
        return res.reverse();
    }

    public static void main(String[] args) {
        StringBuilder toBin = toBinary(8);
        System.out.println(toBin);
    }
}
