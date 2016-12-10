import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static char[][] screen = new char[6][50];

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader (new FileReader("day8input.txt"));
            String line;
            int res = 0;
            while ((line = br.readLine()) != null) {
                Main.fillScreen(line);
            }
            System.out.println(Main.numPixels());
        } finally {}
    }

    public static void fillScreen(String s) {
        if (s.startsWith("rect")) {
            String[] instructions = s.split(" ");
            String[] parameters = instructions[1].split("x");
            int width = Integer.parseInt(parameters[0]);
            int height = Integer.parseInt(parameters[1]);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    screen[y][x] = '#';
                }
            }

        } else {
            String[] instructions = s.split(" ");
            // row = y
            // column = x
            String shiftStr = instructions[instructions.length -1];
            int shift = Integer.parseInt(shiftStr);
            boolean isColumn = false;
            int col = 0;
            int row = 0;

            String[] specificRowOrColumn = instructions[2].split("=");
            if (specificRowOrColumn[0].equals("x")) {
                isColumn = true;
                col = Integer.parseInt(specificRowOrColumn[1]);
            } else {
                row = Integer.parseInt(specificRowOrColumn[1]);
            }

            if (isColumn) {
                char[] columnCopy = new char[screen.length];
                for (int c = 0; c < columnCopy.length; c++) {
                    columnCopy[c] = screen[c][col];
                }
                for (int c1 = 0; c1 < columnCopy.length; c1++) {
                    screen[(c1 + shift) % columnCopy.length][col] = columnCopy[c1];
                }
            } else {
                char[] rowCopy = Arrays.copyOf(screen[row], screen[row].length);
                for (int c = 0; c < rowCopy.length; c++) {
                    screen[row][(c + shift) % rowCopy.length ] = rowCopy[c];
                }
            }
        }
    }

    public static int numPixels() {
        int res = 0;
        for (int y = 0; y < screen.length; y++) {
            for (int x = 0; x < screen[0].length; x++) {
                if (screen[y][x] == '#') res++;
            }
        }
        return res;
    }
}



