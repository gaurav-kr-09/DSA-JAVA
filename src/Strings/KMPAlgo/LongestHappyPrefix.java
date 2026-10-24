package Strings.KMPAlgo;

public class LongestHappyPrefix {
    public static String longestPrefix(String s) {
        int[] lps = computeLPS(s);
        for(int num: lps) System.out.print(num + " ");

        return s.substring(0, lps[s.length()-1]);// kyuki last element hi happy prefix batayega pure string ka);
    }

    public static int[] computeLPS(String s){
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        lps[0] = 0;

        int i=1;
        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0) len = lps[len-1];
                else i++; // lps[i] = 0 by default hoga
            }
        }

        return lps;
    }

    public static void main(String[] args) {

        String s1 = "level";
        System.out.println(longestPrefix(s1)); // Expected: "l"

        String s2 = "ababab";
        System.out.println(longestPrefix(s2)); // Expected: "abab"

        String s3 = "leetcodeleet";
        System.out.println(longestPrefix(s3)); // Expected: "leet"

        String s4 = "a";
        System.out.println(longestPrefix(s4)); // Expected: ""

        String s5 = "aaaaa";
        System.out.println(longestPrefix(s5)); // Expected: "aaaa"

        String s6 = "abcabc";
        System.out.println(longestPrefix(s6)); // Expected: "abc"

        String s7 = "abcdabc";
        System.out.println(longestPrefix(s7)); // Expected: "abc"

        String s8 = "abcdef";
        System.out.println(longestPrefix(s8)); // Expected: ""
    }
}