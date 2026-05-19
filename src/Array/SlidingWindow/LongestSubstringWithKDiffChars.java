package Array.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKDiffChars {
    // BruteForce
    /*public static int longestKSubstrLC(String s, int k) {
        int n = s.length(), longest = -1;
        for(int i=0; i<n; i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j=i; j<n; j++){
                hs.add(s.charAt(j));
                if(hs.size() > k) break;
                longest = Math.max(longest, j-i+1);
            }
        }

        return longest;
    }*/

    /*public static int longestKSubstrGFG(String s, int k) {
        int n = s.length(), longest = -1;
        for(int i=0; i<n; i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j=i; j<n; j++){
                hs.add(s.charAt(j));
                if(hs.size() == k){
                    longest = Math.max(longest, j-i+1);
                }else if(hs.size() > k) break;
            }
        }

        return longest;
    }*/

    // Optimal
    public static int longestKSubstrLC(String s, int k) {
        int n = s.length(), longest = -1;
        HashMap<Character, Integer> freq = new HashMap<>();

        int i=0, j=0;
        while(j < n){
            char ch = s.charAt(j);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
            // while(freq.size() > k){ // OR if v chalega
            if(freq.size() > k){
                char curr = s.charAt(i);
                int currFreq = freq.get(curr);
                if(currFreq == 1) freq.remove(curr);
                else freq.put(curr, currFreq-1);
                i++;
            }

            longest = Math.max(longest, j-i+1);
            j++;
        }

        return longest;
    }

    public static int longestKSubstrGFG(String s, int k) {
        int n = s.length(), longest = -1;
        HashMap<Character, Integer> freq = new HashMap<>();

        int i=0, j=0;
        while(j < n){
            char ch = s.charAt(j);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
            if(freq.size() == k) longest = Math.max(longest, j-i+1);
                // else while(freq.size() > k){ // OR if v chalega
            else if(freq.size() > k){
                char curr = s.charAt(i);
                int currFreq = freq.get(curr);
                if(currFreq == 1) freq.remove(curr);
                else freq.put(curr, currFreq-1);
                i++;
            }

            j++;
        }

        return longest;
    }

    public static void main(String[] args) {
        String s = "aaabbccda";
        int k = 2;
        System.out.println("Longest substring with at most k different chars is: " + longestKSubstrLC(s, k)); // 5
        System.out.println("Longest substring with k different chars is: " + longestKSubstrGFG(s, k)); // 5

        s = "aaaa";
        k = 2;
        System.out.println("Longest substring with at most k different chars is: " + longestKSubstrLC(s, k)); // 4
        System.out.println("Longest substring with k different chars is: " + longestKSubstrGFG(s, k)); // -1
    }
}
