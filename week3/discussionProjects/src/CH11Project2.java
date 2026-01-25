
/*
 * Area of a convex Polygon
 * Write a program that prompts the user to enter the number of points in a
 * convex
 * polygon, enter the points clockwise, then displays the area of the Polygon
 * Area = 1/2[(x_1*y_2 + x_2*y_3 + x_3*y_4 + ... + x_n+y_1)-(y_1*x_2 + y_2*x_3 +
 * y_3*x_4 + ... + y_n+x_1)]
 *
 * Sample run:
 * >> Enter the number of points: 7
 * >> Enter the coordinates of the points:
 * >> 12 0 -8.5 10 0 11.4 5.5 7.8 6 -5.5 0 -7 3.5 -5.5
 * >> The total area is 244.57
 */
import java.util.Scanner;
import java.util.ArrayList;

public class CH11Project2 {
    public static void main(String[] args) {
        // initialize new scanner object
        Scanner input = new Scanner(System.in);

        // Initialize ArrayLists for x and y coordinates
        ArrayList<Double> xList = new ArrayList<>();
        ArrayList<Double> yList = new ArrayList<>();

        // prompt user input for number of vertices, each vertex is (x: double, y:
        // double)
        System.out.print("Enter the number of points: ");

        // store user input into variable
        int numVertices = input.nextInt();

        // prompt user input for the coordinates
        System.out.println("Enter the coordinates of the points:");

        // add user input to each list in pairs
        for (int i = 0; i < numVertices; i++) {
            double xCoord = input.nextDouble();
            double yCoord = input.nextDouble();
            xList.add(xCoord);
            yList.add(yCoord);
        }
        input.close();

        // perform calculations using the matrixSum method
        double leftHandSide = matrixSum(xList, yList);
        double rightHandSide = matrixSum(yList, xList);

        // finish calculating the area
        double area = (leftHandSide - rightHandSide) / 2.0;

        System.out.printf("\nThe total area is %.2f", area);
    }

    // This static method handles the math since each side of the equation
    public static double matrixSum(ArrayList<Double> list1, ArrayList<Double> list2) {
        double sum = 0;
        for (int i = 0, j = 1; i < list1.size() - 1; i++, j++) {
            // iterate through each list and calculate the sum according to the formula
            sum += list1.get(i) * list2.get(j);
        }
        // Perform the last calculation according to the formula
        sum += list1.get(list1.size() - 1) * list2.get(0);
        return sum;
    }
}
