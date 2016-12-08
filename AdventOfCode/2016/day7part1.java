import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader (new FileReader("day7input.txt"));
            String line;
            int res = 0;
            while ((line = br.readLine()) != null) {
                res += Main.supportsTLS(line);
            }
            System.out.println(res);
        } finally {}
    }
    public static int supportsTLS(String s) {
        String[] strArr = s.split("\\[|\\]");
        boolean supportsTLS = false;
        for (int x = 0; x < strArr.length; x++) {
            boolean currStringSupportTLS = false;
            for (int y = 1; y < strArr[x].length() - 2; y++) {
                if (strArr[x].charAt(y + 1) == strArr[x].charAt(y)
                   && strArr[x].charAt(y+2) == strArr[x].charAt(y-1)
                   && strArr[x].charAt(y) != strArr[x].charAt(y-1)) {
                    currStringSupportTLS = true;
                    supportsTLS = true;
                }
            }
            // it fails to support TLS if in the [] brackets
            // Note: there may be multiple [] but values inside [] are always odd indexes in the input
            if (currStringSupportTLS && x % 2 == 1) return 0;
        }
        if (supportsTLS) return 1;
        return 0;
    }
}
