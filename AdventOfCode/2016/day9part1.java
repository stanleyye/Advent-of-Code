import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader (new FileReader("day9input.txt"));
            String line;
            int res = 0;
            while ((line = br.readLine()) != null) {
                res += Main.decompressedLength(line);
            }
            System.out.println(res);
        } finally {}
    }
    
    public static int decompressedLength(String s) {
        String res = "";

        for (int c = 0; c < s.length(); c++) {
            if (s.charAt(c) == '(') {
                String subCharStr = "";
                boolean passedX = false;
                String repeatNumStr = "";

                c++;

                while (s.charAt(c) != '(' && s.charAt(c) != ')') {
                    char charVal = s.charAt(c);

                    if (charVal == 'x') {
                        passedX = true;
                        c++;
                        continue;
                    }

                    if (!passedX) {
                        subCharStr += String.valueOf(charVal);
                    } else {
                        repeatNumStr += String.valueOf(charVal);
                    }
                    c++;
                }

                int subChar = Integer.parseInt(subCharStr);
                int repeatNum = Integer.parseInt(repeatNumStr);

                String repeatedStr = "";
                if (s.charAt(c) == ')') {
                    c++;
                    repeatedStr = s.substring(c, c + subChar);
                }
                
                for (int r = 0; r < repeatNum; r++) {
                    res += repeatedStr;
                }
                c = c + subChar - 1;
            } else {
                res += String.valueOf(s.charAt(c));
            }
        }
        return res.length();
    }
}



