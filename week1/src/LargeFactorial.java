import java.util.Scanner;
import java.math.*;

public class LargeFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter and integer: ");
        int n = input.nextInt();
        input.close();
        System.out.println(n + "! is \n" + factorial(n));
    }

    public static BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            result = result.multiply(new BigInteger(i + ""));
        return result;
    }
}
