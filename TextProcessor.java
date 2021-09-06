import java.util.Scanner;

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