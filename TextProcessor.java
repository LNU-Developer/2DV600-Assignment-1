import java.util.Scanner;

public class TextProcessor {

    static char[] alphabet = "abcdefghijklmnopqrstuvwxyzåäöABCDEFGHIJKLMNOPQRSUVWXYZÅÄÖ".toCharArray();
    static char[] vowel = "aeiouyåäö".toCharArray();

    public static void main(String args[]) {
        try {
            System.out.println("Type a line of text: ");
            Scanner reader = new Scanner(System.in);
            String text = reader.nextLine();
            reader.close();

            String newText = replaceStringWithNextLetter(text);
            System.out.println("After Processing: " + newText);

        } catch (Exception e) {
            System.out.println("Some unexplained error has occured.");
        }
    }

    public static String replaceStringWithNextLetter(String originalString) {
        StringBuilder newString = new StringBuilder();

        String alphabetString = new String(alphabet);
        String vowelString = new String(vowel);

        for (int i = 0; i < originalString.length(); i++) {
            char ch = originalString.charAt(i);

            int indexOfAlphabet = alphabetString.indexOf(ch);
            if (indexOfAlphabet != -1) {
                if (indexOfAlphabet >= alphabet.length)
                    newString.append(alphabet[0]);
                else
                    newString.append(alphabet[indexOfAlphabet + 1]);
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