package Strings.KMPAlgo;

public class RotateStringLC796 {
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String text = s + s;
        return search(goal, text) != -1;
    }

    public static int search(String patt, String text){
        int n = text.length();
        int m = patt.length();

        int[] LPS = computeLPS(patt);

        int i=0;
        int j=0;
        while(i < n){
            if(text.charAt(i) == patt.charAt(j)){
                i++;
                j++;
            }

            if(j == m) return i-j;
            else if(i < n && text.charAt(i) != patt.charAt(j)){
                if(j != 0) j = LPS[j-1];
                else i++;
            }
        }

        return -1;
    }

    private static int[] computeLPS(String patt) {
        int m = patt.length();
        int[] LPS = new int[m];

        int len = 0; // length of previos equal longest prefix and suffix
        LPS[0] = 0;

        int i = 1;
        while (i < m){
            if(patt.charAt(i) == patt.charAt(len)){
                len++;
                LPS[i] = len;
                i++;
            }else{
                if(len != 0) len = LPS[len-1];
                else{
                    LPS[i] = 0;
                    i++;
                }
            }
        }

        return LPS;
    }

    public static void main(String[] args) {

        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println(rotateString(s1, goal1)); // Expected: true

        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println(rotateString(s2, goal2)); // Expected: false

        String s3 = "a";
        String goal3 = "a";
        System.out.println(rotateString(s3, goal3)); // Expected: true

        String s4 = "abc";
        String goal4 = "abc";
        System.out.println(rotateString(s4, goal4)); // Expected: true

        String s5 = "abc";
        String goal5 = "acb";
        System.out.println(rotateString(s5, goal5)); // Expected: false

        String s6 = "aa";
        String goal6 = "a";
        System.out.println(rotateString(s6, goal6)); // Expected: false
    }
}