/*
* Date: 2021-09-07.
* File Name: TextProcessor.Java
* Author: Rickard Marjanovic
*
*/

import java.util.Scanner;

/**
 * Class Description: This class is to showcase the Text Proccessor class
 *
 * @version 1, 2021-09-07
 * @author Rickard Marjanovic
 */
class RunTextProcessor {
    public static void main(String args[]) {
        try {
            System.out.println("Type a line of text: ");
            Scanner reader = new Scanner(System.in);
            String text = reader.nextLine();
            reader.close();

            TextProcessor tp = new TextProcessor();
            String newText = tp.replaceStringWithNextLetter(text);
            System.out.println("After Processing: " + newText);

        } catch (Exception e) {
            System.out.println("Some unexplained error has occured.");
        }
    }
}

/**
 * Class Description: This class is to change each letter of a text to the next
 * letter in the alphabet as well as capitalizing any vowels
 *
 * @version 1, 2021-09-07
 * @author Rickard Marjanovic
 */
public class TextProcessor {

    char[] alphabet = "abcdefghijklmnopqrstuvwxyzåäöABCDEFGHIJKLMNOPQRSUVWXYZÅÄÖ".toCharArray();
    char[] vowel = "aeiouyåäö".toCharArray();

    public String replaceStringWithNextLetter(String originalString) {
        StringBuilder newString = new StringBuilder();

        String alphabetString = new String(this.alphabet);
        String vowelString = new String(this.vowel);

        for (int i = 0; i < originalString.length(); i++) {
            char ch = originalString.charAt(i);

            int indexOfAlphabet = alphabetString.indexOf(ch);
            if (indexOfAlphabet != -1) {
                if (indexOfAlphabet >= this.alphabet.length)
                    newString.append(this.alphabet[0]);
                else
                    newString.append(this.alphabet[indexOfAlphabet + 1]);
            } else
                newString.append(ch);

            int indexOfVowel = vowelString.indexOf(newString.charAt(i));

            if (indexOfVowel != -1) {
                newString.setCharAt(i, Character.toUpperCase(newString.charAt(i)));
            }
        }
        return newString.toString();
    }
}