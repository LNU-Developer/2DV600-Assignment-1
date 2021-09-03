import java.util.Scanner;
import java.util.InputMismatchException;

class ISBN {
    public static void main(String args[]) {
        System.out.println("Enter the first 9 digits of an ISBN as integer: ");

        String stringDigits = input9ISBN();

        Boolean validatedNumbers = isCorrectISBNSyntax(stringDigits);

        if (validatedNumbers) {
            int checksum = calculateChecksum(stringDigits);
            System.out.println(checksum);
            String checksumDigit;
            if (checksum != 10)
                checksumDigit = Integer.toString(checksum);
            else
                checksumDigit = "X";
            System.out.println("The ISBN-10 number is " + stringDigits + checksumDigit);

        }
    }

    public static String input9ISBN() {
        Scanner reader = new Scanner(System.in);
        String number = reader.next();
        reader.close();
        return number;
    }

    public static Boolean isCorrectISBNSyntax(String stringDigits) {
        try {
            Integer.parseInt(stringDigits); // To prompt an error if not numverical value
            if (stringDigits.length() != 9)
                throw new NumberFormatException();
            return true;
        } catch (InputMismatchException e) {
            System.out.println("Please only write numbers.");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Please only write 9 digits, no more, no less.");
            return false;
        } catch (Exception e) {
            System.out.println("Some unexplained error has occured.");
            return false;
        }
    }

    public static int calculateChecksum(String stringNumber) {
        int sum = 0;
        for (int i = 1; i <= stringNumber.length(); ++i) {
            sum += i * Character.getNumericValue(stringNumber.charAt(i - 1));
        }
        return sum % 11;
    }
}