import java.lang.Math;

public class day5part1 {
  public static void main(String[] args) throws Exception {
    String input = "uqwqemis";
    String temp = input;
    String res = "";
    int index = 0;
    for (int x = 0; x < input.length(); x++) {
        while (!temp.startsWith("00000")) {
            temp += Integer.toString(index);
            temp = new String(day5part1.MD5(temp));
            //System.out.println(temp);
        }
      	//System.out.println(temp);
        if (temp != null) {
            res += Character.toString(temp.charAt(5));
        }
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
