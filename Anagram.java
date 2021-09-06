import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class RunAnagram {
    public static void main(String args[]) {

        Scanner reader = new Scanner(System.in);
        String text = reader.nextLine();
        reader.close();

        Anagram am = new Anagram("wordlist");
        System.out.println(am.buildAnagramString(text));
    }
}

public class Anagram {
    String[] anagramStrings;

    public Anagram(String filename) {
        anagramStrings = importData(filename);
    }

    String[] importData(String filename) {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(filename));
            List<String> list = new ArrayList<String>();
            String string;

            while ((string = buff.readLine()) != null) {
                list.add(string);
            }
            buff.close();

            return list.toArray(new String[] {});
        } catch (Exception e) {
            e.printStackTrace();
            return new String[] {};
        }
    }

    boolean areAnagrams(char[] string1, char[] string2) {
        int length1 = string1.length;
        int length2 = string2.length;

        if (length1 != length2)
            return false;

        Arrays.sort(string1);
        Arrays.sort(string2);

        for (int i = 0; i < length1; i++)
            if (string1[i] != string2[i])
                return false;

        return true;
    }

    public String buildAnagramString(String word) {
        String str = "";
        for (String string : this.anagramStrings) {
            boolean areAnagrams = areAnagrams(word.toCharArray(), string.toCharArray());
            if (areAnagrams)
                str += string + ", ";
        }
        return str.substring(0, str.length() - 2);
    }
}
