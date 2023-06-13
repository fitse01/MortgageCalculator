import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello and welcome to calculate a mortgage payment!");
        final int annualMonth = 12;
        final int percent = 100;
        Scanner scan = new Scanner(System.in);

        // Get the principal
        int principal = 0;
        try {
            System.out.print("Please enter the amount of the principal: ");
            principal = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        // Get the annual interest rate
        float annualInterestRate = 0;
        try {
            System.out.print("Please enter the annual interest rate in percent: ");
            annualInterestRate = scan.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        // Get the loan term
        int loanTerm = 0;
        try {
            System.out.print("Please enter the loan term in years: ");
            loanTerm = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        // Calculate the mortgage payment
        Float monthlyInterestRate = (annualInterestRate / percent) / annualMonth;
        int n = loanTerm * annualMonth;
        double power = Math.pow(1 + monthlyInterestRate, n);
        double mortgagePayment = principal * (monthlyInterestRate * power) / (power - 1);

        // Format the result as currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgagePayment);

        // Display the result
        System.out.print("The total amount of your mortgage payment is ");
        System.out.println(result);
        System.out.println("Thank you for using the mortgage calculator!");
        // closing the scanner.
        scan.close();
    }
}