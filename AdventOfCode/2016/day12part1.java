import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static int[] registers = new int[4];
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader (new FileReader("day12input.txt"));
            String line;
            List<String> listOfInstructions = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                listOfInstructions.add(line);
            }
            System.out.println(Main.execInstructions(listOfInstructions));
        } finally {}
    }

    public static int execInstructions(List<String> instructions) {
        for (int x = 0; x < instructions.size(); x++) {
            String[] instruction = instructions.get(x).split(" ");
            
            System.out.println(x + " " + Arrays.toString(registers));
            switch (instruction[0]) {

                case "cpy":
                    registers[instruction[2].charAt(0) - 'a'] = (isNumeric(instruction[1])) ? Integer.valueOf(instruction[1]) : registers[instruction[1].charAt(0) - 'a'];
                    break;
                case "inc":
                    registers[instruction[1].charAt(0) - 'a']++;
                    break;
                case "dec":
                    registers[instruction[1].charAt(0) - 'a']--;
                    break;
                case "jnz":
                    if (isNumeric(instruction[1])) {
                        if (Integer.valueOf(instruction[1]) != 0) {

                            x+= Integer.valueOf(instruction[2]);
                            x--;
                        }
                    } else if (registers[instruction[1].charAt(0) - 'a'] != 0){
                        x+= Integer.valueOf(instruction[2]);
                        x--;
                    }
                    break;
                default:
                    break;
            }
        }
        return registers[0];
    }

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}



