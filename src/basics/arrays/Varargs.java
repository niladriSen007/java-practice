package basics.arrays;

public class Varargs {

//     Concatenates multiple strings into one string.
//     * @param strings Variable number of string arguments.
//     * @return Concatenated string.

    public static String concatenateString(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString();
    }

    static void main() {
        String s = concatenateString("Hello", "World", "Niladri");
        System.out.println(s);
    }
}
