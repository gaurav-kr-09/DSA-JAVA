package DynamicProgramming.Memoization;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestCmnSubstring {
    // BASIC RECURSION
    public static int longestCommonSubstring(String a, String b) {
        // count maintain karega abhi tak ka LC substring
        return lcStr(0, 0, a, b, 0);
    }

    private static int lcStr(int i, int j, String a, String b, int count) {
        if(i == a.length() || j == b.length()) return count; // aab koi common nahi rhega

        int curr = count;
        if(a.charAt(i) == b.charAt(j)) curr = lcStr(i+1, j+1, a, b, count+1);

        // agar koi char skip kare to consec count reset ho jayega 0
        int skipA = lcStr(i+1, j, a, b, 0);
        int skipB = lcStr(i, j+1, a, b, 0);

        return Math.max(curr, Math.max(skipA, skipB));
    }

    // MEMOIZATION IS UNNECESSARILY COMPLICATED
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "abcde";
        String s2 = "abfce";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 2

        // Test Case 2
        s1 = "abcdxyz";
        s2 = "xyzabcd";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 4

        // Test Case 3
        s1 = "zxabcdezy";
        s2 = "yzabcdezx";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 6

        // Test Case 4
        s1 = "abc";
        s2 = "def";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 0

        // Test Case 5
        s1 = "aaaa";
        s2 = "aa";
        System.out.println(longestCommonSubstring(s1, s2));
        // Expected: 2
    }
}