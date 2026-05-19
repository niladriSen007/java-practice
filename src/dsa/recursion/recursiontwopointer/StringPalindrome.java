package dsa.recursion.recursiontwopointer;

public class StringPalindrome {

    static boolean checkStringPalindrome(int left, String input) {
        int right = input.length() - left - 1;
        if (left >= right)
            return true;
        if (input.charAt(left) != input.charAt(right))
            return false;
        return checkStringPalindrome(left + 1, input);
    }

    public static void main(String[] args) {
        String ip = "MADAMI";
        boolean res = checkStringPalindrome(0, ip);
        System.out.println(res);
    }
}
