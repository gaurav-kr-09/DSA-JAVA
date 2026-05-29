package Array.MissingQns;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) map.put(order.charAt(i), i);

        for(int i=0; i< words.length-1; i++){
            String curr = words[i], next = words[i+1];
            for(int j=0; j<curr.length(); j++){
                if(j >= next.length()) return false; // apple & app
                if(map.get(curr.charAt(j)) > map.get(next.charAt(j))) return false; // abc and bac
                if(map.get(curr.charAt(j)) < map.get(next.charAt(j))) break;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"will", "chris", "abd", "adb", "bat", "batman", "batoman"};
        String order = "wcabdefhgjilknmopqrsuxtvyz";
        System.out.println(isAlienSorted(words, order));
    }
}