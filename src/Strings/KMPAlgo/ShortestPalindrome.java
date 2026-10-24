package Strings.KMPAlgo;

public class ShortestPalindrome {
    // BruteForce
    /*public static String shortestPalindrome(String s) {
        int n = s.length();

        int end = n;
        while (end > 0) {
            if (isPal(s, 0, end - 1)) {
                StringBuilder sb = new StringBuilder(s.substring(end, n));
                sb.reverse();
                return sb.toString() + s;
            }
            end--;
        }

        return ""; // ye to kabhi return hi nai hoga
    }

    public static boolean isPal(String s, int i, int j){
        while(i < j)
            if(s.charAt(i++) != s.charAt(j--))
                return false;

        return true;
    }*/

    // bruteforce with better idea
    /*public static String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        for(int i=0; i<n; i++){
            if(s.substring(0, n-i).equals(rev.substring(i, n))){
                return rev.substring(0, i) + s;
            }
        }

        return "";
    }*/

    // KMP best
    public static String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        String temp = s + "-" + rev;
        int[] lps = computeLPS(temp);

        int longestLps = lps[temp.length()-1];
        return rev.substring(0, n - longestLps) + s;
    }

    public static int[] computeLPS(String s){
        int n = s.length();
        int[] lps = new int[n];

        lps[0] = 0;
        int len = 0;

        int i = 1;
        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i++] = len;
            }else{
                if(len != 0) len = lps[len-1];
                else lps[i++] = 0;
            }
        }

        return lps;
    }

    public static void main(String[] args) {

        String s1 = "aacecaaa";
        System.out.println(shortestPalindrome(s1)); // Expected: "aaacecaaa"

        String s2 = "abcd";
        System.out.println(shortestPalindrome(s2)); // Expected: "dcbabcd"

        String s3 = "a";
        System.out.println(shortestPalindrome(s3)); // Expected: "a"

        String s4 = "aba";
        System.out.println(shortestPalindrome(s4)); // Expected: "aba"

        String s5 = "abb";
        System.out.println(shortestPalindrome(s5)); // Expected: "bbabb"

        String s6 = "abcdabc";
        System.out.println(shortestPalindrome(s6)); // Expected: "cbadcbabcdabc"

        String s7 = "";
        System.out.println(shortestPalindrome(s7)); // Expected: ""

        String s8 = "aaaa";
        System.out.println(shortestPalindrome(s8)); // Expected: "aaaa"
    }
}