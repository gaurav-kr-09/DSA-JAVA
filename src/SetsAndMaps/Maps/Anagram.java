package SetsAndMaps.Maps;

import java.util.HashMap;

public class Anagram {
    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch: t.toCharArray()){
            int freq = map.getOrDefault(ch, 0);
            if(freq == 0) return false;
            map.put(ch, freq-1);
        }

        // for(char key: map.keySet()) if(map.get(key) != 0) return false;
        // not req since length mismatch is already checked

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}