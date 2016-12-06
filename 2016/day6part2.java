import java.io.*;
import java.util.*;

public class Main {
    public static int[] maxArr;
    public static char[] charArr;

    public static void main(String[] args) throws Exception {
        Map<Integer, HashMap<Character, Integer>> m = new HashMap<>();

        try {
            maxArr = new int[8];
            charArr = new char[8];
            BufferedReader br = new BufferedReader (new FileReader("day6input.txt"));
            String line;
            int res = 0;
            while ((line = br.readLine()) != null) {
                Main.record(m, line);
            }
            Main.findLeast(m);
            System.out.println(new String(charArr));
        } finally {}

    }
    public static void record(Map<Integer, HashMap<Character, Integer>> m, String s) {
        for (int x = 0; x < s.length(); x++) {
            if (!m.containsKey(x)) {
                m.put(x, new HashMap<Character, Integer>());
            }
            HashMap<Character, Integer> hm = m.get(x);
            if (!hm.containsKey(s.charAt(x))) {
                hm.put(s.charAt(x), 1);
            } else {
                hm.put(s.charAt(x), hm.get(s.charAt(x)) + 1);
            }

            int amount = hm.get(s.charAt(x));
            if (amount > maxArr[x]) {
                maxArr[x] = amount;
                charArr[x] = s.charAt(x);
            }
        }
    }
    public static void findLeast(Map<Integer, HashMap<Character, Integer>> m) {
        for (Integer col : m.keySet()) {
            int leastAmount = Integer.MAX_VALUE;
            for (Character charKey : m.get(col).keySet()) {
                int currAmount = m.get(col).get(charKey);
                if (currAmount < leastAmount) {
                    leastAmount = currAmount;
                    charArr[col] = charKey;
                }
            }
        }
    }

}
