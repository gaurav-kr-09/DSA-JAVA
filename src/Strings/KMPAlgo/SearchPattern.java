package Strings.KMPAlgo;

import java.util.ArrayList;

public class SearchPattern {
    public static ArrayList<Integer> search(String patt, String text){
        int n = text.length();
        int m = patt.length();

        // lps nikal lete hai -> to store the length of
        // longest proper prefix of patt[0...i] which is also
        // suffix of pattt[0...i] i.e longest prefix suffix (LPS)
        int[] LPS = computeLPS(patt);

        ArrayList<Integer> foundAt = new ArrayList<>();
        // apply KMP code
        int i=0;
        int j=0;
        while(i < n){
            if(text.charAt(i) == patt.charAt(j)){
                i++;
                j++;
            }

            if(j == m) { // mil gaya
                foundAt.add(i-j);
                j = LPS[j-1];
            }else if(i < n && text.charAt(i) != patt.charAt(j)){
                if(j != 0) j = LPS[j-1];
                else i++;
            }
        }

        return foundAt;
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
        // Test Case 1
        String text1 = "abesdu";
        String patt1 = "edu";
        System.out.println(search(patt1, text1));
        // Expected: []

        // Test Case 2
        String text2 = "geeksforgeeks";
        String patt2 = "geek";
        System.out.println(search(patt2, text2));
        // Expected: [0, 8]

        // Test Case 3: Overlapping matches
        String text3 = "aaaaa";
        String patt3 = "aa";
        System.out.println(search(patt3, text3));
        // Expected: [0, 1, 2, 3]

        // Test Case 4: patttern equals text
        String text4 = "abc";
        String patt4 = "abc";
        System.out.println(search(patt4, text4));
        // Expected: [0]

        // Test Case 5: No match
        String text5 = "abcdef";
        String patt5 = "xyz";
        System.out.println(search(patt5, text5));
        // Expected: []

        // Test Case 6: Repeated prefix
        String text6 = "ababcabcabababd";
        String patt6 = "ababd";
        System.out.println(search(patt6, text6));
        // Expected: [10]
    }
}