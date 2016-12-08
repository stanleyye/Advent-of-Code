import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "uqwqemis";
        String res = "";
        int index = 0;
        
        for (int x = 0; x < input.length(); x++) {
            String temp = input + Integer.toString(index);
            while (!temp.startsWith("00000")) {
                temp = Main.MD5(input + Integer.toString(index));
                index++;
            }
            index++;
            res += Character.toString(temp.charAt(5));
        }
        System.out.println(res);
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
