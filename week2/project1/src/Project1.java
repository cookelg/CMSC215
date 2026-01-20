
/** 
===================================================================================
- CMSC215
- Project 1 Player Roster Program
- Lawrence Cooke

- Project1.java
- This class contains the main method to run the player roster program
- The user is prompted for player information repeatedly until a blank line is 
  detected by the Scanner object
- the input should be formatted as "name age feet inches"
- For example: "frank 21 5 11"

===================================================================================
*/
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        // initialize new Scanner object for system.in
        Scanner input = new Scanner(System.in);

        // initialize new roster object using the PlayerRoster class
        PlayerRoster roster1 = new PlayerRoster();

        // declare boolean variable to be the sentinal for the do-while loop
        boolean hasInput;

        /*
         * do-while loop handles user input. if user enters a blank line, hasInput
         * is set to false and the loop ends. Each line of the input is handled in
         * a new Scanner object.
         */
        do {
            System.out.print("Enter player's name, age, and height in feet and inches: ");

            // Initialize String variable that stores all the contents on the given line
            String inputLine = input.nextLine();

            // if the String is empty, hasInput is set to false.
            hasInput = !(inputLine.isEmpty());

            // If an input exists, the next block will create and store a new Player
            if (hasInput) {

                // Initialize a new Scanner object that reads the input line
                Scanner line = new Scanner(inputLine);

                // Reads the next String, stores it in a variable
                String name = line.next();

                // Reads the next three ints, stores it in a variable
                int age = line.nextInt();
                int feet = line.nextInt();
                int inches = line.nextInt();

                // closes the Scanner
                line.close();

                // initializes a new Player and stores it in the PlayerRoster
                roster1.addPlayer(name, age, feet, inches);
            }
        } while (hasInput); // the while loop terminates when the input line is empty

        // close the System.in Scanner
        input.close();

        // checks if the user input any players
        if (roster1.getSize() > 0) {
            System.out.printf("\nThe average age of all players is %.2f\n", roster1.getAverageAge());
            System.out.println("Tallest player whose average age is less than the average is:");
            System.out.println(roster1.getTallYoungster().toString());
        } else { // if the user input no players, the message will print
            System.out.println("No player data entered.");
        }
    }
}
