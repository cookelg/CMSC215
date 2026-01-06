import java.util.Scanner;

public class TestLoan {
    /** Main Method */
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Enter yearly interest rate
        System.out.print(
                "Enter annual interest rate: ");
        double annualInterestRate = input.nextDouble();

        // ener number of Years
        System.out.print("Enter number of years: ");
        int numberOfYears = input.nextInt();

        // enter loan amount
        System.out.print("Enter loan amount: ");
        double loanAmount = input.nextDouble();

        // close scanner
        input.close();

        // create Loan object
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

        System.out.println(loan.getAnnualInterestRate());
        System.out.println(loan.getNumberOfYears());
        System.out.println(loan.getLoanAmount());

        // Display loan date, monthly payment, and total payment
        System.out.printf("the load was created on %s\n" +
                "The monthly payment is %.2f\nThe total payment is %.2f\n", loan.getLoanDate().toString(),
                loan.getMonthlyPayment(), loan.getTotalPayment());
    }
}
