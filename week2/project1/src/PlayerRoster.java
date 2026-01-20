
/** 
===================================================================================
- CMSC215
- Project 1 Player Roster Program
- Lawrence Cooke

- PlayerRoster.java
- This class uses an ArrayList initialized for Player objects
- As players are being added to the roster, private methods in this class will 
  automatically set the values for average age and check for the tallest player 
  who's age is equal to or less than the average age
===================================================================================
*/
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

    private void setAverageAge() {
        if (getSize() > 0)
            averageAge = (double) ageSum / getSize();
    }

    /** determines the current tall youngster in the roster */
    private void setTallYoungster() {
        if (getSize() > 0) {
            int max = 0;
            for (Player player : roster) {
                if (player.getAge() <= averageAge && player.toInches() > max) {
                    max = player.toInches();
                    this.tallYoungster = player;
                }
            }
        }
    }

    /** returns the tallest Player who's age <= average age */
    public Player getTallYoungster() {
        return tallYoungster;
    }

    /** instantiates a new player object and adds it to the roster */
    public void addPlayer(String name, int age, int feet, int inches) {
        roster.add(new Player(name, age, feet, inches));
        ageSum += age;
        setAverageAge();
        setTallYoungster();
    }

    /** Adds an existing player to the roster */
    public void addPlayer(Player player) {
        roster.add(player);
        ageSum += player.getAge();
        setAverageAge();
        setTallYoungster();
    }

    /** Returns the player that was added last */
    public Player getPlayer() {
        return roster.get(getSize() - 1);
    }

    /** Returns the player at the specified index */
    public Player getPlayer(int index) {
        return roster.get(index);
    }

    /** removes the player at the last index, or the last player to be added */
    public Player removePlayer() {
        Player player = roster.get(getSize() - 1);
        ageSum -= player.toInches();
        roster.remove(getSize() - 1);
        setAverageAge();
        setTallYoungster();
        return player;
    }

    /** removes a player at a specific index */
    public Player removePlayer(int index) {
        Player player = roster.get(index);
        ageSum -= player.getAge();
        roster.remove(index);
        setAverageAge();
        setTallYoungster();
        return player;
    }

    /** Returns the roster contents */
    @Override
    public String toString() {
        return "roster: " + roster.toString();
    }

    /** Main method for testing */
    public static void main(String[] args) {
        PlayerRoster roster1 = new PlayerRoster();
        roster1.addPlayer("Steve", 21, 6, 12);
        roster1.addPlayer("Frank", 16, 4, 2);
        roster1.addPlayer("Amanda", 35, 7, 11);
        System.out.println(roster1.getSize());
        System.out.println(roster1.getAverageAge());
        System.out.println(roster1.getTallYoungster());
        roster1.addPlayer("James", 99, 9, 11);
        System.out.println("Added " + roster1.getPlayer().getName());
        System.out.println(roster1.getSize());
        System.out.println(roster1.getAverageAge());
        System.out.println("the tallest youngster is " + roster1.getTallYoungster());
        System.out.println(roster1.toString());
        Player lastAdded = roster1.getPlayer();
        Player indexZero = roster1.getPlayer(0);
        System.out.println("the last player added was " + lastAdded.toString());
        System.out.println("the player at index 0 is: " + indexZero.toString());
        System.out.println("removed " + roster1.removePlayer(2).getName());
        System.out.println("new size: " + roster1.getSize());
        System.out.println(roster1.getAverageAge());
        System.out.println("the tallest youngster is " + roster1.getTallYoungster());
        System.out.println(roster1.toString());
    }
}
