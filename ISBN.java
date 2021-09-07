/*
* Date: 2021-09-07.
* File Name: ISBN.Java
* Author: Rickard Marjanovic
*
*/

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Class Description: This class is to try out the ISBN class.
 *
 * @version 1, 2021-09-07
 * @author Rickard Marjanovic
 */

class RunISBN {
    public static void main(String args[]) {
        System.out.println("Enter the first 9 digits of an ISBN as integer: ");
        ISBN isbn = new ISBN();
        if (isbn.isValidSyntax)
            System.out.println("The ISBN-10 number is " + isbn.getChecksumString());

    }
}

/**
 * Class Description: This class is to calculate the last digit of an ISBN when
 * provided 9 figures..
 *
 * @version 1, 2021-09-07
 * @author Rickard Marjanovic
 */

public class ISBN {
    String input;
    Boolean isValidSyntax;

    public ISBN() {
        input = input9ISBN();
        isValidSyntax = isValidISBNSyntax();
    }

    String input9ISBN() {
        Scanner reader = new Scanner(System.in);
        String number = reader.next();
        reader.close();
        return number;
    }

    Boolean isValidISBNSyntax() {
        try {
            Integer.parseInt(this.input); // To prompt an error if not numverical value
            if (this.input.length() != 9)
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

    int calculateChecksum(String stringNumber) {
        int sum = 0;
        for (int i = 1; i <= stringNumber.length(); i++) {
            sum += i * Character.getNumericValue(stringNumber.charAt(i - 1));
        }
        return sum % 11;
    }

    public String getChecksumString() {
        if (isValidSyntax) {
            int checksum = calculateChecksum(this.input);
            String checksumDigit;
            if (checksum != 10)
                checksumDigit = Integer.toString(checksum);
            else
                checksumDigit = "X";
            return this.input + checksumDigit;
        } else
            return "";
    }
}