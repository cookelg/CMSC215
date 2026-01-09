import java.math.*;

public class Scratch {
    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf(Long.MAX_VALUE);
        byte[] arr = num.toByteArray();

        System.out.println(num);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%x ", arr[i]);
        }
        System.out.println("\n" + num.bitLength());

        num = num.shiftRight(1);
        byte[] arr2 = num.toByteArray();
        System.out.println(num);
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("%x ", arr2[i]);
        }
        System.out.println("\n" + num.bitLength());
    }
}
