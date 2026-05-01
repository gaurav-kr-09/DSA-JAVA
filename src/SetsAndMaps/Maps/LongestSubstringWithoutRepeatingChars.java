package SetsAndMaps.Maps;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {
    // Method 1: using the hashset
    /*private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        int i = 0, j = 0;
        while (j < s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)) set.add(ch);
            else{
                maxLen = Math.max(maxLen, j-i);
                while (s.charAt(i) != ch){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            j++;
        }

        maxLen = Math.max(maxLen, j-i);
        return maxLen;
    }*/

    // Method 2: also using the set but better
    /*private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        int i = 0, j = 0;
        while (j < s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)) {
                set.add(ch);
                j++;
                maxLen = Math.max(maxLen, j-i);
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLen;
    }*/

    // Method 3: using map same TC but better
    private static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        int i = 0, j = 0;
        while (j < s.length()){
            char ch = s.charAt(j);

            if(map.containsKey(ch) && map.get(ch) >= i){
                i = map.get(ch) + 1;
            }

            map.put(ch, j);
            j++;
            maxLen = Math.max(maxLen, j-i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";

        int len = lengthOfLongestSubstring(s);
        System.out.println("length of longest substring is: "+ len);
    }
}
