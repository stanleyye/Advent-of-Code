import java.util.*;
import java.io.*;

/**
 * Created by Stanley Ye on 2016-12-03.
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        day4part1 d = new day4part1();
        try {
            BufferedReader br = new BufferedReader (new FileReader("day4input.txt"));
            String line;
            int res = 0;
            while ((line = br.readLine()) != null) {
                res += d.sectorID(line);
            }
            System.out.println(res);
        } finally {}
    }
}

public class day4part1 {
    public int sectorID(String room) {
        String[] strArr = room.split("-");

        String roomNumString = "";
        String checkSum = "";
        String lastStr = strArr[strArr.length - 1];

        boolean isCheckSum = false;
        for (int c = 0; c < lastStr.length(); c++) {
            if (lastStr.charAt(c) == '[') {
                isCheckSum = true;
                continue;
            }
            if (lastStr.charAt(c) == ']') continue;

            if (!isCheckSum) {
                roomNumString += String.valueOf(lastStr.charAt(c));
            } else {
                checkSum += String.valueOf(lastStr.charAt(c));
            }
        }

        // int = [character, total amount of this char]
        // 97 = 'a' in ASCII
        List<int[]> letters = new ArrayList<int[]>();
        for (int fill = 0; fill < 26; fill++) {
            int[] letter = new int[]{ 97 + fill, 0};
            letters.add(letter);
        }

        for (int x = 0; x < strArr.length - 1; x++) {
            String currString = strArr[x];
            for (int y = 0; y < currString.length(); y++) {
                int currIndex = currString.charAt(y) - 'a';
                int[] letter = letters.get(currIndex);
                letter[1]++;
                letters.set(currIndex, letter);
            }
        }

        Collections.sort(letters, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o2[1] - o1[1];
           }
        });

        boolean isReal = true;
        for (int z = 0; z < checkSum.length(); z++) {
            if ((int) checkSum.charAt(z) != letters.get(z)[0]) {
                isReal = false;
                break;
            }
        }
        if (isReal) return Integer.valueOf(roomNumString);
        return 0;
    }
}
