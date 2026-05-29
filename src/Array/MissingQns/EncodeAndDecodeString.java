package Array.MissingQns;

import java.util.ArrayList;

public class EncodeAndDecodeString {
    // ENCODING
    public static String encode(String arr[]) {
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s.length());
            sb.append("/:");
            sb.append(s);
        }

        return sb.toString();
    }

    // DECODING
    public static ArrayList<String> decode(String s) {
        ArrayList<String> ans = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slashStartPosn = s.indexOf("/:", i);
            int len = Integer.parseInt(s.substring(i, slashStartPosn));
            i = slashStartPosn + 2;
            ans.add(s.substring(i, i+len));
            i += len;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"Hello", "World"};
        String encodedStr = encode(arr);
        System.out.println("Encoded string is: " + encodedStr);

        ArrayList<String> decodedArr = decode(encodedStr);
        System.out.println("Decoded string is: " + decodedArr);
    }
}
