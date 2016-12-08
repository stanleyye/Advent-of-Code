import java.io.*;
import java.util.*;

/**
 * Created by Stanley Ye on 2016-12-04.
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        day3part2 d = new day3part2();
        try {
            BufferedReader br = new BufferedReader (new FileReader("day3input.txt"));
            String line;
            int res = 0;
            int countLines = 1;
            String[] lastTwoLines = new String[2];
            while ((line = br.readLine()) != null) {
                if (countLines % 3 == 0) {
                    res += d.isValidTriangle(lastTwoLines[0], lastTwoLines[1], line);
                    countLines++;
                    continue;
                }
                if (countLines % 3 == 1) lastTwoLines[0] = line;
                if (countLines % 3 == 2) lastTwoLines[1] = line;
                countLines++;
            }
            System.out.println(res);
        } finally {}
    }
}

public class day3part2 {

    public int isValidTriangle(String input1, String input2, String input3) {
        String[] inputNumbersStr1 = input1.trim().split("\\s+");
        String[] inputNumbersStr2 = input2.trim().split("\\s+");
        String[] inputNumbersStr3 = input3.trim().split("\\s+");

        int[] inputNums1 = new int[3];
        int[] inputNums2 = new int[3];
        int[] inputNums3 = new int[3];

        for (int x = 0; x < inputNums1.length; x++) {
            if (x == 0) {
                inputNums1[0] = Integer.valueOf(inputNumbersStr1[x]);
                inputNums1[1] = Integer.valueOf(inputNumbersStr2[x]);
                inputNums1[2] = Integer.valueOf(inputNumbersStr3[x]);
            } else if (x == 1) {
                inputNums2[0] = Integer.valueOf(inputNumbersStr1[x]);
                inputNums2[1] = Integer.valueOf(inputNumbersStr2[x]);
                inputNums2[2] = Integer.valueOf(inputNumbersStr3[x]);
            } else {
                inputNums3[0] = Integer.valueOf(inputNumbersStr1[x]);
                inputNums3[1] = Integer.valueOf(inputNumbersStr2[x]);
                inputNums3[2] = Integer.valueOf(inputNumbersStr3[x]);
            }
        }
        // sort the arrays
        Arrays.sort(inputNums1);
        Arrays.sort(inputNums2);
        Arrays.sort(inputNums3);

        int result = 0;
        if (inputNums1[0] + inputNums1[1] > inputNums1[2]) result++;
        if (inputNums2[0] + inputNums2[1] > inputNums2[2]) result++;
        if (inputNums3[0] + inputNums3[1] > inputNums3[2]) result++;

        return result;
    }
}
