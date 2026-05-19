package Array.SlidingWindow;

public class LongestRepeatingCharReplacement {
    // BruteForce
    /*public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for(int i=0; i<n; i++){
            int[] freq = new int[26];
            int maxFreq = 0;

            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                freq[ch-'A']++;

                maxFreq = Math.max(maxFreq, freq[ch-'A']);

                int currLen = j-i+1;
                if(currLen-maxFreq <= k) maxLen = Math.max(maxLen, currLen);
                else break;
            }
        }

        return maxLen;
    }*/

    // OPTIMAL
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        int i=0, j=0;
        int[] freq = new int[26];

        int maxFreq = 0;
        while(j < n){
            char ch = s.charAt(j);
            freq[ch-'A']++;

            maxFreq = Math.max(maxFreq, freq[ch-'A']);

            while((j-i+1) - maxFreq > k){
                freq[s.charAt(i)-'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2)); // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
    }
}