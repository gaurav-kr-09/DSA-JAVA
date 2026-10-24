package Strings.KMPAlgo;

public class FindIndexFirstOccurrenceLC28 {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int[] LPS = computeLPS(needle);

        int i=0;
        int j=0;
        while (i<n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }

            if(j == m) return i-j;
            else if(i < n && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0) j = LPS[j-1];
                else i++;
            }
        }

        return -1;
    }

    private static int[] computeLPS(String needle) {
        int m = needle.length();
        int[] LPS = new int[m];

        int len = 0; // length of previos equal longest prefix and suffix
        LPS[0] = 0;

        int i = 1;
        while (i < m){
            if(needle.charAt(i) == needle.charAt(len)){
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
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(strStr(haystack1, needle1)); // Expected: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr(haystack2, needle2)); // Expected: -1

        String haystack3 = "aaaaa";
        String needle3 = "bba";
        System.out.println(strStr(haystack3, needle3)); // Expected: -1

        String haystack4 = "mississippi";
        String needle4 = "issip";
        System.out.println(strStr(haystack4, needle4)); // Expected: 4

        String haystack5 = "abc";
        String needle5 = "c";
        System.out.println(strStr(haystack5, needle5)); // Expected: 2

        String haystack6 = "abc";
        String needle6 = "abc";
        System.out.println(strStr(haystack6, needle6)); // Expected: 0

        String haystack7 = "aaaa";
        String needle7 = "aaa";
        System.out.println(strStr(haystack7, needle7)); // Expected: 0
    }
}