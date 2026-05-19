package Array.SlidingWindow;

public class MinimumWindowSubstring {
    // OPTIMAL USING HASHMAP
    /*public static String minWindow(String s, String t) {
        int n = s.length();
        if(t.length() > n) return "";

        // Store the frequency of chars of t
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0)+1);

        // sliding window
        int i=0, j=0;
        int reqCount = t.length();
        int minSize = Integer.MAX_VALUE;
        int startI = 0;
        while(j < n){
            char ch = s.charAt(j);

            // IF A CHARACTER MATCHES THEN REDUCE THE REQUIRED COUNT
            if(map.containsKey(ch)){
                int currFreq = map.get(ch);
                if(currFreq > 0) reqCount--;
                map.put(ch, currFreq-1);
            }

            // SHRINKING IF REQUIRED COUNT=0,
            while(reqCount == 0){
                int currSize = j-i+1;

                if(currSize < minSize){
                    minSize = currSize;
                    startI = i;
                }

                // SHRINKING
                char ich = s.charAt(i);
                if(map.containsKey(ich)){
                    int currFreq = map.get(ich);
                    if(currFreq + 1 > 0) reqCount++;
                    map.put(ich, currFreq+1);
                }

                i++;
            }

            j++;
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(startI, startI+minSize);
    }*/

    // OPTIMAL USING FREQUENCY ARRAY
    public static String minWindow(String s, String t) {
        int n = s.length();
        if(t.length() > n) return "";

        // Store the frequency of chars of t
        int[] freq = new int[128];
        for(char ch: t.toCharArray()) freq[ch]++;

        int reqCount = t.length();
        int i=0, j=0;
        int minSize = Integer.MAX_VALUE;
        int startI = 0;

        while (j < n){
            char ch = s.charAt(j);

            if(freq[ch] > 0) reqCount--;
            freq[ch]--;

            while (reqCount == 0){
                int currSize = j-i+1;

                if(currSize < minSize){
                    minSize = currSize;
                    startI = i;
                }

                char ich = s.charAt(i);
                freq[ich]++;

                if(freq[ich] > 0) reqCount++;
                i++;
            }

            j++;
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(startI, startI+minSize);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // BANC
    }
}
