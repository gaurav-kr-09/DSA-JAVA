package SetsAndMaps.Maps;

import java.util.HashMap;

public class NoOfEqualPairsInString {
    private static long equalPairs(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0)+1);

        int pairs = 0;
        for(int val: map.values()) pairs += (val * val);

        return pairs;
    }

    public static void main(String[] args) {
        String s = "ananya";
        // 3 + 3 + 3 + 2 + 2 + 1 = 14 ans i.e. summation of square of each frequency

        System.out.println("no. of equal pairs is: "+ equalPairs(s));
    }
}
