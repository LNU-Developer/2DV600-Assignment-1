/*
* Date: 2021-09-07.
* File Name: Codestrip.Java
* Author: Rickard Marjanovic
*
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

/**
 * Class Description: This class is to run the code strip class.
 *
 * @version 1, 2021-09-07
 * @author Rickard Marjanovic
 */

class RunCodestrip {
    public static void main(String args[]) {
        Codestrip cs = new Codestrip();
        String[] code = cs.importCode("HelloWorld.java");
        String cleanCode = cs.stripComments(code);

        System.out.println(cleanCode);
        System.out.println("Number of actual lines of code: " + cs.actualLines);
        System.out.println("Number of blank lines removed: " + cs.removedBlankLines);
        System.out.println("Number of comments removed: " + cs.removedComments);
    }
}

/**
 * Class Description: This class is to load a java file and strip it of
 * comments, as well as provide stats.
 *
 * @version 1, 2021-09-07
 * @author Rickard Marjanovic
 */

public class Codestrip {
    int actualLines = 0;
    int removedBlankLines = 0;
    int removedComments = 0;

    public String stripComments(String[] code) {
        StringBuilder str = new StringBuilder();

        for (String row : code) {
            if (!isCommentOrEmpy(row.trim())) {
                str.append(row);
                str.append("\n");
            }
        }

        str.setLength(str.length() - 1);
        return str.toString();
    }

    public boolean isCommentOrEmpy(String row) {
        String[] strip = { "/**", "/*", "*/", "//", "*" };
        for (int i = 0; i < strip.length; i++) {
            if (row.isBlank()) {
                this.removedBlankLines++;
                return true;
            }

            if (row.startsWith(strip[i])) {
                if (row.startsWith(strip[2]) || row.startsWith(strip[3])) {
                    this.removedComments++;
                }
                return true;
            }

        }
        this.actualLines++;
        return false;
    }

    public String[] importCode(String filename) {
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
}
