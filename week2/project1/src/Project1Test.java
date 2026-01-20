import java.util.Scanner;

public class Project1Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PlayerRoster roster1 = new PlayerRoster();
        boolean hasInput;
        do {
            String inputLine = input.nextLine();
            hasInput = !(inputLine.isEmpty());
            if (hasInput) {
                Scanner line = new Scanner(inputLine);
                String name = line.next();
                int age = line.nextInt();
                int feet = line.nextInt();
                int inches = line.nextInt();
                line.close();
                roster1.addPlayer(name, age, feet, inches);
            }
        } while (hasInput);
        input.close();
        System.out.println("The average age is " + roster1.getAverageAge());
        System.out.println("The tallest younsgster is " +
                roster1.getTallYoungster().toString());
        System.out.println("=================================================");
        for (int i = 0; i < roster1.getSize(); i++) {
            Player player = roster1.getPlayer(i);
            String name = player.getName();
            int age = player.getAge();
            int inchHeight = player.toInches();
            String height = player.getHeight();
            System.out.printf("Index %d: %s\n\tAge: %d %s\n\tHeight: %s / %d inches\n",
                    i, name, age, (age <= roster1.getAverageAge() ? " at or below average age" : " above average age"),
                    height,
                    inchHeight);
            if (player.equals(roster1.getTallYoungster()))
                System.out.println(name + " is the tallest youngster");
            System.out.println("=================================================");
        }
    }
}
