import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int length = sc.nextInt();
        String str = sc.nextLine();
        int longestWordOutsideParen = 0;
        int numWordsInParen = 0;

        int x = 0;
        boolean insideParen = false;
        while (x < str.length()) {
            int currWord = 0;

            if (str.charAt(x) == '(') {
                insideParen = true;
                x++;
                continue;
            }
            if (str.charAt(x) == ')') {
                insideParen = false;
                x++;
                continue;
            }

            if (str.charAt(x) == '_') {
                x++;
                continue;
            }

            if (insideParen) {
                // inside parenthesis
                while(x < str.length() && str.charAt(x) != '_' && str.charAt(x) != ')' && str.charAt(x) != '(') {
                    x++;
                }
                numWordsInParen++;
            } else {
                // not inside parenthesis
                while (x < str.length() && str.charAt(x) != '_' && str.charAt(x) != ')' && str.charAt(x) != '(') {
                    currWord++;
                    x++;
                }
            }
            longestWordOutsideParen = Math.max(currWord, longestWordOutsideParen);
        }

        out.print(longestWordOutsideParen + " ");
        out.print(numWordsInParen);
        
        out.close();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}