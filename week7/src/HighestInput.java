import java.util.Scanner;

public class HighestInput {
    public static int findHighestResponse(Scanner input) {
        int highest = input.hasNextInt() ? input.nextInt() : 0;
        if (!input.hasNextInt())
            return highest;
        else
            return Math.max(highest, findHighestResponse(input));

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input a list of integers. when done, input a char: ");
        int highestResponse = findHighestResponse(input);

        System.out.println("Highest Input: " + highestResponse);
    }
}
