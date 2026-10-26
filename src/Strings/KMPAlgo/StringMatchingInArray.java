package Strings.KMPAlgo;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInArray {
    // Method 1: inbuilt method
    /*public static List<String> stringMatching(String[] words) {
        int n = words.length;

        List<String> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(words[j].contains(words[i])){
                    ans.add(words[i]);
                    break; // to avoid adding multiple times
                }
            }
        }

        return ans;
    }*/

    // Method - 2: same bas contains ki jagah KMP
    public static List<String> stringMatching(String[] words) {
        int n = words.length;

        List<String> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(search(words[i], words[j])){
                    ans.add(words[i]);
                    break; // to avoid adding multiple times
                }
            }
        }

        return ans;
    }

    public static boolean search(String patt, String text){
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

            if(j == m) return true;
            else if(i < n && text.charAt(i) != patt.charAt(j)){
                if(j != 0) j = LPS[j-1];
                else i++;
            }
        }

        return false;
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
        String[] words1 = {"mass", "as", "hero", "superhero"};
        System.out.println(stringMatching(words1));
        // Expected: ["as", "hero"]

        String[] words2 = {"leetcode", "et", "code"};
        System.out.println(stringMatching(words2));
        // Expected: ["et", "code"]

        String[] words3 = {"blue", "green", "bu"};
        System.out.println(stringMatching(words3));
        // Expected: []

        String[] words4 = {"a", "abc", "bc", "d"};
        System.out.println(stringMatching(words4));
        // Expected: ["a", "bc"]

        String[] words5 = {"aaa", "aaaa", "aaaaa"};
        System.out.println(stringMatching(words5));
        // Expected: ["aaa", "aaaa"]

        String[] words6 = {"abc", "abc", "bc"};
        System.out.println(stringMatching(words6));
        // Expected: ["abc", "abc", "bc"]
    }
}