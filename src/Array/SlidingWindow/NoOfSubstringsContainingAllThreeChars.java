package Array.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class NoOfSubstringsContainingAllThreeChars {
    // BrurteForce
    /*public static int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i=0; i<n-2; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i; j<n ;j++){
                Character ch = s.charAt(j);
                set.add(ch);
                if(set.size() == 3){
                    count += (n-j);
                    break;
                }
            }
        }

        return count;
    }*/

    // Optimal TC O(n) Sc O(4)
    /*public static int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int i=0, j=0;
        while(j < n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            if(map.size() == 3){
                count += (n-j);
                char currChar = s.charAt(i);
                int currFreq = map.get(currChar);

                if(currFreq == 1) map.remove(currChar);
                else map.put(currChar, currFreq-1);

                i++;
            }

            j++;
        }

        return count;
    }*/

    // Optimal and even better
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;

        int lastA = -1;
        int lastB = -1;
        int lastC = -1;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch == 'a') lastA = i;
            else if(ch == 'b') lastB = i;
            else lastC = i;

            count += Math.min(lastA, Math.min(lastB, lastC)) + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc"; // ANS 10
        // The substrings containing at least one occurrence
        // of the characters a, b and c are  "abc", "abca", "abcab",
        // "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

        System.out.println(numberOfSubstrings(s));
    }
}