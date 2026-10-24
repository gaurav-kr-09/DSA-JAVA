package Strings.KMPAlgo;

public class RepeatedSubstringPattern {
    // METHOD 1 - brutefroce good for understanding
    /*public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int len = 1; len <= n/2; len++){
            if(n % len != 0) continue;

            String patt = s.substring(0, len);
            StringBuilder sb = new StringBuilder();

            for(int i=1; i<=n/len; i++) sb.append(patt);

            if(s.equals(sb.toString())) return true;
        }

        return false;
    }*/

    // METHOD 2 -  Inbuilt method
    /*public static boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // 1st and last char skip and check presence
        return doubled.substring(1, doubled.length()-1).contains(s);
    }*/

    // METHOD 3 - KMP based
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        int[] lps = computeLPS(s);
        int len = n - lps[n-1]; // len of smallest unit that may repeat

        return lps[n-1] > 0 && n % len == 0;
    }

    private static int[] computeLPS(String patt) {
        int m = patt.length();
        int[] LPS = new int[m];

        int len = 0; // length of previous equal longest prefix and suffix
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
        String s1 = "abab";
        System.out.println(repeatedSubstringPattern(s1)); // Expected: true

        String s2 = "aba";
        System.out.println(repeatedSubstringPattern(s2)); // Expected: false

        String s3 = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s3)); // Expected: true

        String s4 = "a";
        System.out.println(repeatedSubstringPattern(s4)); // Expected: false

        String s5 = "aaaa";
        System.out.println(repeatedSubstringPattern(s5)); // Expected: true

        String s6 = "abac";
        System.out.println(repeatedSubstringPattern(s6)); // Expected: false

        String s7 = "ababab";
        System.out.println(repeatedSubstringPattern(s7)); // Expected: true

        String s8 = "abaababaab";
        System.out.println(repeatedSubstringPattern(s8)); // Expected: true

        String s9 = "abcdabc";
        System.out.println(repeatedSubstringPattern(s9)); // Expected: false
    }
}