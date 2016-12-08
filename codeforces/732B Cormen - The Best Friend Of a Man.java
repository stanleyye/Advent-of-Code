import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt(); // number of days
        int k = sc.nextInt(); // min number of walks

        int additionalWalks = 0;
        int[] schedule = new int[n];
        int[] dp = new int[n];

        for (int a = 0; a < n; a++) {
            schedule[a] = sc.nextInt();
        }
        dp[0] = schedule[0];

        for (int b = 1; b < n; b++) {
            if (dp[b-1] >= k) {
                dp[b] = schedule[b];
                continue;
            }
            int extra = k - dp[b-1];
            dp[b] = Math.max(schedule[b], extra);
            if (extra > schedule[b]) additionalWalks += (extra - schedule[b]);
        }
        out.println(additionalWalks);
        for (int c = 0; c < dp.length; c++) {
            if (c != dp.length - 1) {
                out.print(dp[c] + " ");
            } else {
                out.print(dp[c]);
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
