import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "uqwqemis";
        char[] res = new char[input.length()];
        int index = 0;
        boolean[] filled = new boolean[input.length()];

        for (int x = 0; x < input.length(); x++) {
            String temp = input + Integer.toString(index);
            while (!temp.startsWith("00000") || (temp.startsWith("00000") && (( !Character.isDigit(temp.charAt(5))
                    || Character.getNumericValue(temp.charAt(5)) >= filled.length
                    || filled[Character.getNumericValue(temp.charAt(5))])))) {
                temp = Main.MD5(input + Integer.toString(index));
                index++;
            }

            int position = Character.getNumericValue(temp.charAt(5));
            if (position < filled.length) {
                filled[position] = true;
                res[position] = temp.charAt(6);
            }
            index++;
        }
        System.out.println(new String(res));
    }
    public static String MD5(String md5) throws Exception {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } finally {}

    }
}
