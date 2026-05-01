package SetsAndMaps.Maps;

import java.util.HashMap;

public class MostFreqCharInString {
    private static char getMaxFreq(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        // for(char ch: str.toCharArray()){
        //     if(map.containsKey(ch)){
        //         int freq = map.get(ch);
        //         map.put(ch, freq+1);
        //     }
        //     else map.put(ch, 1);
        // }

        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int maxfreq = 0;
        char ans = 'z';
        for(char ch: map.keySet()){
            int currFreq = map.get(ch);
            if(currFreq > maxfreq){
                maxfreq = currFreq;
                ans = ch;
            }
            else if(currFreq == maxfreq && ch < ans) ans = ch;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "output";
        System.out.println("The  lexicographically smallest most freq char is: " + getMaxFreq(str));
    }
}
