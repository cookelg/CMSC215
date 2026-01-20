/**
 * ===================================================================================
 * - CMSC215
 * - Project 1 Player Roster Program
 * - Lawrence Cooke
 * 
 * - Height.java
 * - This class stores player height information
 * - The constructor will normalize inputs into feet and inches
 * - for example: "5 14" will be stored as "6 2"
 * ===================================================================================
 */
public class Height {
    private int feet;
    private int inches;

    /**
     * Height(feet: int, inches: int): returns int
     * Description: Constructor method that will normalize feet and inches inputs
     * such that inches < 12. If inches > 12, measurement will be converted to
     * feet/inches appropriately
     */
    public Height(int feet, int inches) {
        this.feet = inches / 12 + feet;
        this.inches = inches % 12;
    }

    /**
     * getFeet(): returns int
     * Description: getter method for this.feet data field
     */
    public int getFeet() {
        return feet;
    }

    /**
     * getInches(): returns int
     * Description: getter method for this.inches data field
     */
    public int getInches() {
        return inches;
    }

    /**
     * toInches(): returns int
     * Description: returns height measurement converted from Feet to inches.
     */
    public int toInches() {
        return feet * 12 + inches;
    }

    /**
     * toString(): returns String
     * Description: returns String containing this.feet concatenated with single
     * quote to denote Feet and this.inches concatenated with double quote to
     * denote Inches
     */
    public String toString() {
        return feet + "' " + inches + "\"";
    }

    /** Main method to test class methods toString and toInches() */
    public static void main(String[] args) {
        // initialize new Height Objects x and y
        Height x = new Height(6, 10);
        Height y = new Height(4, 14);

        // display method output strings to STDOUT
        System.out.println("x toString: " + x.toString());
        System.out.println("y toString: " + y.toString());
        System.out.println("x toInches: " + x.toInches());
        System.out.println("x toInches: " + y.toInches());
    }
}
