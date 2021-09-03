import java.util.Scanner;
import java.util.InputMismatchException;

public class ArmstrongNumber {
    public static void main(String args[]) {
        try {
            int runAgain;
            Scanner reader = new Scanner(System.in);
            do {
                runAgain = 0;
                Boolean appRunCorrectly = runApp(reader);
                if (appRunCorrectly) {
                    System.out.println("Do you want to repeat? (1/0): ");
                    runAgain = reader.nextInt();
                }
            } while (runAgain == 1);
            reader.close();
        } catch (InputMismatchException e) {
            System.out.println("Please only write numbers.");
        } catch (Exception e) {
            System.out.println("Some unexplained error has occured.");
        }
    }

    public static Boolean runApp(Scanner reader) {
        try {
            System.out.println("Enter the starting number of the range: ");
            int startRange = reader.nextInt();
            System.out.println("Enter the ending number of the range: ");
            int endRange = reader.nextInt();

            System.out.println("The Armstrong numbers between the given range are: ");
            for (int i = startRange; i <= endRange; i++) {
                if (isArmstrongNumber(i))
                    System.out.println(i);
            }
            return true;

        } catch (InputMismatchException e) {
            System.out.println("Please only write numbers.");
            return false;
        } catch (Exception e) {
            System.out.println("Some unexplained error has occured.");
            return false;
        }
    }

    public static Boolean isArmstrongNumber(int number) {
        String stringNumber = String.valueOf(number);

        int sum = 0;
        for (int i = 0; i < stringNumber.length(); i++) {
            sum += Math.pow(Character.getNumericValue(stringNumber.charAt(i)), stringNumber.length());
        }

        if (sum == number)
            return true;
        else
            return false;
    }
}
