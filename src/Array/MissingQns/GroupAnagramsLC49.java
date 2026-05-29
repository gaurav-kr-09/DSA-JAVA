package Array.MissingQns;
import java.util.*;

public class GroupAnagramsLC49 {
    // method 1: O(n * kLogK) -> k is length of larget string
    /*public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] curr = str.toCharArray();
            Arrays.sort(curr);

            String key = new String(curr);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }*/

    // method 2: still not O(n * k) -> k is length of larget string
    /*public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            // Storing the frequencies
            int[] freq = new int[26];
            for(char c: s.toCharArray()) freq[c-'a']++;

            // sorting with frequency array
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                int currFreq = freq[i];
                if(currFreq > 0){
                    while(currFreq != 0){
                        sb.append((char) (i+'a'));
                        currFreq--;
                    }
                }
            }

            // maintaining the map
            String sorted = sb.toString();
            if(!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());
    }*/

    // Method 2 optimized ->
    // instead of rebuilding sorted string make the freq array the key
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            // Storing the frequencies
            int[] freq = new int[26];
            for(char c: s.toCharArray()) freq[c-'a']++;

            // sorting with frequency array
            StringBuilder sb = new StringBuilder();
            for(int f: freq){
                sb.append('#').append(f);
            }

            // maintaining the map
            String key = sb.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(strs);
        for(List<String> ls: ans) System.out.println(ls);
    }
}