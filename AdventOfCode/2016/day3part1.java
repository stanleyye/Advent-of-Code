import java.io.*;
import java.util.*;

/**
 * Created by Stanley Ye on 2016-12-04.
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        day3part1 d = new day3part1();
        try {
            BufferedReader br = new BufferedReader (new FileReader("day3input.txt"));
            String line;
            int res = 0;
            while ((line = br.readLine()) != null) {
                res += d.isValidTriangle(line);
            }
            System.out.println(res);
        } finally {}
    }
}

public class day3part1 {
    public int isValidTriangle(String input) {
        String[] inputNumbersStr = input.trim().split("\\s+");
        int[] inputNums = new int[3];
        for (int x = 0; x < inputNums.length; x++) {
            inputNums[x] = Integer.valueOf(inputNumbersStr[x]);
        }
        // sort the array
        for (int x = 1; x < inputNums.length; x++) {
            int i = x;
            while (i > 0 && inputNums[i] < inputNums[i-1]){
                int temp = inputNums[i];
                inputNums[i] = inputNums[i-1];
                inputNums[i-1] = temp;
                i--;
            }
        }
        System.out.println(Arrays.toString(inputNums));
        if (inputNums[0] + inputNums[1] > inputNums[2]) return 1;
        // else
        return 0;
    }
}
