public class StringReverser {
    public static String reverseString(String str) {
        if (str.length() <= 1)
            return str;
        else
            return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println("abcdefg -> " + reverseString("abcdefg"));
        System.out.println("Lawrence -> " + reverseString("Lawrence"));
    }
}
