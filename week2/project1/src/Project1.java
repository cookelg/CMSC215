import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PlayerRoster roster1 = new PlayerRoster();

        String name;
        int age;
        int feet;
        int inches;

        // TODO
        // fix the do while to look for an empty input to break the loop

        do {
            System.out.print("Enter player's name, age, and height in feet and inches: ");
            name = input.next();
            age = input.nextInt();
            feet = input.nextInt();
            inches = input.nextInt();
            roster1.addPlayer(name, age, feet, inches);
            System.out.print(" | " + roster1.getPlayer().getName() + " added.");
        } while (input.hasNext());
        input.close();

        if (roster1.getSize() > 0) {
            System.out.printf("\nThe average age of all players is %.2f", roster1.getAverageAge());
            System.out.println("Tallest player whose average age is less than the average is:");
            System.out.println(roster1.getTallYoungster().toString());
        } else {
            System.out.println("No player data entered.");
        }
    }
}
