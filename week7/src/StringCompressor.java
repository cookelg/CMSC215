public class StringCompressor {
    public static String compressString(String s) {
        if (s.length() <= 1)
            return s;
        else if (s.charAt(0) == s.charAt(1)) {
            int count = 2;
            while (count < s.length() && s.charAt(0) == s.charAt(count)) {
                count++;
            }
            return s.charAt(count - 1) + String.valueOf(count) + compressString(s.substring(count));
        } else
            return s.charAt(0) + compressString(s.substring(1));

    }

    public static void main(String[] args) {
        System.out.println("aaabbcz -> " + compressString("aaabbcz"));
        System.out.println("ZZZZZbbcbccz -> " + compressString("ZZZZZbbcbccz"));
    }
}
