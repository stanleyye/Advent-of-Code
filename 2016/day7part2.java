import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            HashMap<String, Integer> aba = new HashMap<>();
            HashMap<String, Integer> bab = new HashMap<>();

            BufferedReader br = new BufferedReader (new FileReader("day7input.txt"));
            String line;
            int res = 0;
            while ((line = br.readLine()) != null) {
                res += Main.supportsSSL(line, aba, bab);
                aba.clear();
                bab.clear();
            }
            System.out.println(res);
        } finally {}
    }
    public static int supportsSSL(String s, HashMap<String, Integer> aba, HashMap<String, Integer> bab) {
        String[] strArr = s.split("\\[|\\]");
        boolean supportsSSL = false;
        for (int x = 0; x < strArr.length; x++) {
            boolean currStringSupportSSL = false;
            for (int y = 1; y < strArr[x].length() - 1; y++) {
                if (strArr[x].charAt(y + 1) == strArr[x].charAt(y-1)
                   && strArr[x].charAt(y) != strArr[x].charAt(y-1)) {

                    String currString = Character.toString(strArr[x].charAt(y-1)) +
                            Character.toString(strArr[x].charAt(y)) +
                            Character.toString(strArr[x].charAt(y+1));

                    String oppositeString = Character.toString(strArr[x].charAt(y)) +
                            Character.toString(strArr[x].charAt(y+1)) +
                            Character.toString(strArr[x].charAt(y));

                    // Note: there may be multiple [] but values inside [] are always odd indexes in the input
                    if (x % 2 == 1) {
                        if (bab.containsKey(currString)) return 1;
                        aba.put(oppositeString, 1);
                    } else {
                        if (aba.containsKey(currString)) return 1;
                        bab.put(oppositeString, 1);
                    }

                }
            }
        }
        return 0;
    }
}
