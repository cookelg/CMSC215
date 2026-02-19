import java.util.Scanner;

public class PositiveCounter {
    public static int countPositive(Scanner input) {
        if (!input.hasNextInt())
            return 0;
        else if (input.nextInt() <= 0)
            return countPositive(input);
        else
            return 1 + countPositive(input);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int positives = countPositive(input);

        System.out.println("There were " + positives + " positives input");
    }
}
