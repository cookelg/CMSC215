public class IsPrimeRecursive {
    public static void main(String[] args) {
        System.out.println("is 21 prime? " + isPrime(21, 2));
        System.out.println("is 45 prime? " + isPrime(45, 2));
        System.out.println("is 51 prime? " + isPrime(51, 2));
        System.out.println("is 2 prime? " + isPrime(2, 2));
    }

    public static boolean isPrime(int n, int divisor) {
        if (divisor == n)
            return true;
        else if (n % divisor == 0)
            return false;
        else
            return isPrime(n, divisor + 1);
    }
}
