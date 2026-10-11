package DynamicProgramming.PartitionDP;

import java.util.HashMap;
import java.util.Map;

public class ScrambleStringSubsBased {
    // BASIC RECURSION
    /*public static boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }

    public static boolean solve(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;

        int n = s1.length();
        for(int i=1; i<n; i++){
            boolean swap = solve(s1.substring(0, i), s2.substring(n-i, n))
                    && solve(s1.substring(i, n), s2.substring(0, n-i));
            if(swap) return true;

            boolean notSwap = solve(s1.substring(0, i), s2.substring(0, i))
                    && solve(s1.substring(i, n), s2.substring(i, n));
            if(notSwap) return true;
        }

        return false;
    }*/

    // MEMOIZATION
    public static boolean isScramble(String s1, String s2) {
        Map<String, Boolean> dp = new HashMap<>();
        return solve(s1, s2, dp);
    }

    public static boolean solve(String s1, String s2, Map<String, Boolean> dp){
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;

        // handling DP
        String key = s1 + "+" + s2;
        if(dp.containsKey(key)) return dp.get(key);

        int n = s1.length();
        boolean ans = false; // extra variable lenge to dp filling easier
        for(int i=1; i<n; i++){
            boolean swap = solve(s1.substring(0, i), s2.substring(n-i, n), dp)
                    && solve(s1.substring(i, n), s2.substring(0, n-i), dp);
            if(swap){
                ans = true;
                break;
            }

            boolean notSwap = solve(s1.substring(0, i), s2.substring(0, i), dp)
                    && solve(s1.substring(i, n), s2.substring(i, n), dp);
            if(notSwap) {
                ans = true;
                break;
            }
        }

        dp.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {

        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(isScramble(s1, s2)); // Expected: true

        String s3 = "abcde";
        String s4 = "caebd";
        System.out.println(isScramble(s3, s4)); // Expected: false

        String s5 = "a";
        String s6 = "a";
        System.out.println(isScramble(s5, s6)); // Expected: true

        String s7 = "abc";
        String s8 = "bca";
        System.out.println(isScramble(s7, s8)); // Expected: true
    }
}