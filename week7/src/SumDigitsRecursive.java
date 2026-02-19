public class SumDigitsRecursive {
    public static void main(String[] args) {
        System.out.println("Digit sum of 12345 is " + sumDigits(12345));
        System.out.println("Digit sum of 999 is " + sumDigits(999));
    }

    public static int sumDigits(int n) {
        if (n / 10 == 0)
            return n;
        else
            return n % 10 + sumDigits(n / 10);
    }
}
