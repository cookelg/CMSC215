import java.util.ArrayList;

public class PlayerRoster {
    private ArrayList<Player> roster = new ArrayList<>();
    private int ageSum;
    private double averageAge;
    private Player tallYoungster;

    public boolean isEmpty() {
        return roster.isEmpty();
    }

    public int getSize() {
        return roster.size();
    }

    public double getAverageAge() {
        return averageAge;
    }

    /** determines the current tall youngster in the roster */
    private void setTallYoungster() {
        if (getSize() > 0) {
            int max = 0;
            for (Player player : roster) {
                if (player.getAge() >= averageAge && player.toInches() > max) {
                    max = player.toInches();
                    this.tallYoungster = player;
                }
            }
        }
    }

    /** returns a String for the tallest Player who's age <= average age */
    public String getTallYoungster() {
        return tallYoungster.toString();
    }

    /** instantiates a new player object and adds it to the roster */
    public void addPlayer(String name, int age, int feet, int inches) {
        roster.add(new Player(name, age, feet, inches));
        ageSum += age;
        if (getSize() > 0)
            averageAge = (double) ageSum / getSize();
        setTallYoungster();
    }

    /** removes the player at the last index, or the last player to be added */
    public Player removePlayer() {
        Player player = roster.get(getSize() - 1);
        roster.remove(getSize() - 1);
        return player;
    }

    /** removes a player at a specific index */
    public Player removePlayer(int index) {
        Player player = roster.get(index);
        roster.remove(index);
        return player;
    }

    /** removes a player that matches the String argument */
    // public Player removePlayer(String name) {
    // //
    // }
}
