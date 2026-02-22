import java.util.Scanner;

/**
 * Chapter 18 Programming Project 5: Decimal to Binary Converter
 *
 * - Write a recursive method that converts a decimal number into binary number
 * as a
 * string
 * - Write a test program that prompts the user to enter a decimal number and
 * displays its binary equivalent
 *
 * Date: 2026-02-21
 * 
 * @author Lawrence Cooke
 **/
public class DecimalToBinary {
    // Helper method.
    public static String dec2Bin(int value) {

        // StringBuilder method used in order to avoid cluttering memory
        StringBuilder binString = new StringBuilder();

        // Not the base case, this method with return a string "0" if user inputs 0
        if (value == 0)
            return binString.append(0).toString();

        // If the user inputs a positive number,the appropriate power of 2 will be
        // calculated. A signed binary positive number will be returned to the caller
        // as a String.
        else if (value > 0) {
            int powerOf2 = getPowerOf2(value, 0);
            dec2Bin(value, powerOf2, 0, binString);
            return binString.toString();
        } else {
            // if the user inputs a negative number, the two's compliment represention
            // as a signed binary string will be returned.
            int powerOf2 = getPowerOf2(Math.abs(value), 0);
            dec2Bin(Math.abs(value), powerOf2, 0, binString);
            twosCompliment(binString);
            return binString.toString();
        }
    }

    /**
     * Iterative method that uses StringBuilder to store the binary string
     * Each subsequent call of this method decrements the power of 2 until the base
     * case is met: power2 is greater than 0
     * 
     * @param value     integer with the user input
     * @param powerOf2  used to control the base case, holds the current 2^n
     * @param compareTo initially set to 0, each iteration tests value against
     *                  Math.pow(2, powerOf2) + compareTo
     * @param binString StringBuilder object that holds the output binary string
     */
    public static void dec2Bin(int value, int powerOf2, int compareTo, StringBuilder binString) {
        // base case
        if (powerOf2 >= 0) {
            if (compareTo + (int) Math.pow(2, powerOf2) > value) {
                binString.append(0);
                dec2Bin(value, powerOf2 - 1, compareTo, binString);
            } else {
                binString.append(1);
                compareTo += (int) Math.pow(2, powerOf2);
                dec2Bin(value, powerOf2 - 1, compareTo, binString);
            }
        }
    }

    /**
     * Iterative method that returns the appropriate power of 2
     *
     * @param value  contains the user input
     * @param power2 2^n initially set to zero, subsequent calls are set to 2^n+1
     */
    public static int getPowerOf2(int value, int power2) {
        if (value <= (int) Math.pow(2, power2))
            return power2;
        else
            return getPowerOf2(value, power2 + 1);
    }

    /** Two's compliment method, for any inputs that are negative */
    public static void twosCompliment(StringBuilder binString) {
        // invert all bits: 0 -> 1 and 1 -> 0
        for (int i = 0; i < binString.length(); i++) {
            if (binString.charAt(i) == '0')
                binString.replace(i, i + 1, "1");
            else
                binString.replace(i, i + 1, "0");
        }
        // add 1 to the inverted binary number: If the last bit is 1, change it to 0
        // then change all following 1's to zero. When the first 0 is found, change
        // it to a 1, then break out of the loop.
        for (int i = binString.length() - 1; i >= 0; i--) {
            if (binString.charAt(i) == '1')
                binString.replace(i, i + 1, "0");
            else {
                binString.replace(i, i + 1, "1");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal integer: ");
        int value = input.nextInt();
        input.close();
        System.out.printf("\n%d decimal is binary %s", value, dec2Bin(value));
    }
}
