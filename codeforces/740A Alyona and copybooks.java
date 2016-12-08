import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static PrintWriter out;

    public static long min = Long.MAX_VALUE;
    public static long stopVal = Long.MAX_VALUE;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        long n = sc.nextInt(); // initial amount of books
        long a = sc.nextInt(); // cost for 1 book
        long b = sc.nextInt(); // cost for 2 books
        long c = sc.nextInt(); // cost for 3 books

        if (n % 4 != 0) {
            List<Long> l = new ArrayList<>();
            l.add(c);
            l.add(b);
            l.add(a);

            Main.findMin(n, l, 0);
            out.print(min);
        } else {
            out.print(0);
        }

        out.close();
    }
    public static void findMin(long numBooks, List<Long> l, long rubles) {
        if (numBooks > stopVal) return;
        if (numBooks % 4 == 0) {
            if (rubles >= 0) min = Math.min(min, rubles);
            if (stopVal == Long.MAX_VALUE) {
                stopVal = numBooks;
            }
            return;
        }
        for (int x = 0; x < l.size(); x++) {
            findMin(numBooks + l.size() - x, l, rubles + l.get(x));
        }
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
