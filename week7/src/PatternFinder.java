public class PatternFinder {
    public static boolean findPattern(String s) {
        if (s.equals("DBD"))
            return true;
        else {
            int low = 0;
            int high = s.length();
            return findPattern(s, low, high);
        }
    }

    public static boolean findPattern(String s, int low, int high) {
        System.out.println(s.substring(low, high));
        if (high < low + 3)
            return false;
        else if (s.substring(low, low + 3).equals("DBD"))
            return true;
        else if (s.substring(high - 3, high).equals("DBD"))
            return true;
        else
            return findPattern(s, low + 1, high - 1);
    }

    public static void main(String[] args) {
        System.out.println("ADDADBDAAA -> " + findPattern("ADDADBDAA"));
        System.out.println("ADDADBCAAA -> " + findPattern("ADDADBCAA"));
        System.out.println("DBD -> " + findPattern("DBD"));
        System.out.println("ADBDADBCAA -> " + findPattern("ADBDADBCAA"));
    }
}
