/**
 * Date: 2026-02-17
 * - This class contains the functionality to calculate the total trip cost
 * - The only class method calculates the total trip cost using the given fields
 * 
 * @author Lawrence Cooke
 */

public class TripCost {
    private double distance;
    private double gasCost;
    private double gasMileage;
    private int numDays;
    private double hotelCost;
    private double foodCost;
    private double attractions;

    /**
     * Class constructor
     *
     * @param distance    A double denoting total distance travelled during the trip
     * @param gasCost     A double denoting the price of gas per liter
     * @param gasMileage  A double denoting fuel efficiency in liters per km
     * @param numDays     An integer denoting total days of the trip
     * @param hotelCost   A double denoting the price of the hotel per day
     * @param foodCost    A double denoting the price of food per day
     * @param attractions A double denoting the total price of all attractions
     *
     */
    public TripCost(double distance, double gasCost, double gasMileage, int numDays,
            double hotelCost, double foodCost, double attractions) {
        this.distance = distance;
        this.gasCost = gasCost;
        this.gasMileage = gasMileage;
        this.numDays = numDays;
        this.hotelCost = hotelCost;
        this.foodCost = foodCost;
        this.attractions = attractions;
    }

    /**
     * Calculates the total cost of the entire trip
     */
    public double getTripCost() {
        double totalGas = gasCost * (distance / gasMileage);
        // print statement to check the accuracy of totalGas
        // System.out.println("total Gas " + totalGas + "\n");
        return numDays * (hotelCost + foodCost) + totalGas + attractions;
    }
}
