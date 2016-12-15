import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt(); // step number
        long k = sc.nextLong(); // kth digit

        if (n== 0 || n==1) {
            out.println(1);
        } else if (k % 2 == 1) {
            out.println(1);
        } else {
            long step = 2;
            long count = 3;
            while (step < (long) n) {
                count = (count * 2) + 1;
                step++;
            }

            long low = 1;
            long high = count;

            long middleVal = (long) n;
            while (low <= high) {
                // binary search overflow
                long middle = (long) Math.ceil(((double) (high - low) / (double) 2) + (double) low);
                if (k < middle) {
                    high = middle - 1;
                    middleVal--;
                } else if (k > middle) {
                    low = middle + 1;
                    middleVal--;
                } else {
                    out.println(middleVal);
                    break;
                }
            }
        }
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