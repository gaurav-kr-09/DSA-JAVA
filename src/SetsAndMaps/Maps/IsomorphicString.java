package SetsAndMaps.Maps;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicString {
    // Method 1: using a single map but can be slower O(nsq) in worst cases
    /*private static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if(map.containsKey(sch)){ // pahle se sch hai kya
                // agar ha to jo tch insert karne ja rhe hai wahi
                // char present hona chahiye koi or hai to false
                if(map.get(sch) != tch) return false;
            }
            // kahi tch pahle se present to nahi hai kisi or value k liye
            else if(map.containsValue(tch)) return false;
            // naye valid pair ko map me dalo
            else map.put(sch, tch);
        }
        return true;
    }*/

    // Method 1: optimized
    private static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mappedChar = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if(map.containsKey(sch)){
                if(map.get(sch) != tch) return false;
            }
            else if(mappedChar.contains(tch)) return false;
            else{
                map.put(sch, tch);
                mappedChar.add(tch);
            }
        }
        return true;
    }

    // Method 2: using two maps and insuring bijective mapping faster
    /*private static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);

            if(sMap.containsKey(sCh) && sMap.get(sCh) != tCh) return false;
            if(tMap.containsKey(tCh) && tMap.get(tCh) != sCh) return false;

            sMap.put(sCh, tCh);
            tMap.put(tCh, sCh);
        }

        return true;
    }*/


    public static void main(String[] args) {
        // String s = "abcda", t = "xyzwp"; // false due to first if condn
        // String s = "abcda", t = "xyxwx"; // false due to else if wala condn
        String s = "abcda", t = "xyzwx"; // true
        System.out.println("s and t are isomorphic -> "+ isIsomorphic(s, t));
    }
}