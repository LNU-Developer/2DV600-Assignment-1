import java.util.Scanner;
import java.util.InputMismatchException;

public class SquareRoot {
    public static void main(String args[]) {
        try {
            System.out.println("This program estimate square roots.");
            System.out.println("Enter an integer to estimate the square root of: ");
            Scanner reader = new Scanner(System.in);
            double sqr = calculateSquareRoot(reader.nextDouble(), 0.01);
            reader.close();
            System.out.println("The estimated square root of 25 is " + String.format("%.2f", sqr));
        } catch (InputMismatchException e) {
            System.out.println("Please only write numbers.");
        } catch (Exception e) {
            System.out.println("Some unexplained error has occured.");
        }
    }

    static double calculateSquareRoot(double n, double accuracy) {
        double guess = n / 2;
        double r = n / guess;

        while (guess - r > accuracy) {
            guess = (guess + r) / 2;
            r = n / guess;
            System.out.println("Current guess: " + guess);
        }
        return n;
    }
}
