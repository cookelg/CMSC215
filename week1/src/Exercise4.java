/*==================================================================================
- Course: CMSC215
- Student: Lawrence Cooke
- Assignment: Week 1 Discussion / Chapter 10: Programing Project 4
- Date: 2026-01-08
- Instructor: Professor Jack Lusby

Requirement:
Write a main method to find and display the first 10 square numbers that are greater
then Long.MAX_VALUE. A square number is a number in the form of n^2. For example: 4,
9, and 16 are square numbers. Try to find an efficient approach to run your program 
fast.
 
 =================================================================================*/

import java.math.*;

public class Exercise4 {
    public static void main(String[] args) {
        /*
         * create a new BigInteger object with a value of Long.MAX_VALUE. This will
         * be used to eventually store the starting point
         */
        BigInteger input = BigInteger.valueOf(Long.MAX_VALUE);

        // BigInteger variable that will eventually point to the root of the first
        // square
        BigInteger firstRoot = BigInteger.valueOf(Long.MAX_VALUE);

        // shift bits right until firstroot^2 is <= input
        while (firstRoot.pow(2).compareTo(input) > 0) {
            firstRoot = firstRoot.shiftRight(1);
        }

        // add 1 to clear the ones e.g. 0111 1111 + 1 = 1000 0000
        // The BigInteger class automatically allocates more memory if needed.
        firstRoot = firstRoot.add(BigInteger.ONE);

        // Starting at the second most significant bit at index located at
        // bitLength - 1: change the bit from 0 to 1, test if the new number^2 is
        // greater than input. if greater than, change the bit back to 0.
        // e.g. firstRoot = (1100 0000)^2 > input ? 1000 0000 : 1100 0000
        for (int i = firstRoot.bitLength() - 1; i > 0; i--) {
            firstRoot = firstRoot.setBit(i);
            if (firstRoot.pow(2).compareTo(input) > 0) {
                firstRoot = firstRoot.clearBit(i);
            }
        }

        // the algorithm above will yield a result less than input. increment
        // firstRoot in while loop until the first root is reached. record the number
        // I was off by.
        int offBy = 0;
        while (firstRoot.pow(2).compareTo(input) < 0) {
            firstRoot = firstRoot.add(BigInteger.ONE);
            offBy++;
        }
        System.out.println("off by: " + offBy);
        System.out.println("input < firstRoot^2 is " +
                (input.compareTo(firstRoot.pow(2)) < 0));
        System.out.println(firstRoot + "^2 = " + firstRoot.pow(2));

        // print the next 10 squares using a for loop, increment firstRoot by 1
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        for (int i = 1; i <= 10; i++) {
            System.out.println("square " + i + " is: " + firstRoot.pow(2) +
                    " with a root of " + firstRoot);
            firstRoot = firstRoot.add(BigInteger.ONE);
        }
    }
}
