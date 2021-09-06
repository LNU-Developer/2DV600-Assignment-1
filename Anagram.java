import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String args[]) {
        String[] anagramStrings = importData();

        Scanner reader = new Scanner(System.in);
        String text = reader.nextLine();
        reader.close();

        String str = buildAnagramString(text, anagramStrings);

        System.out.println(str);

    }

    public static String[] importData() {
        try {
            BufferedReader buff = new BufferedReader(new FileReader("wordlist"));
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

    public static boolean areAnagrams(char[] string1, char[] string2) {
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

    public static String buildAnagramString(String word, String[] anagramStrings) {
        String str = "";
        for (String string : anagramStrings) {
            boolean areAnagrams = areAnagrams(word.toCharArray(), string.toCharArray());
            if (areAnagrams)
                str += string + ", ";
        }
        return str.substring(0, str.length() - 2);
    }
}
