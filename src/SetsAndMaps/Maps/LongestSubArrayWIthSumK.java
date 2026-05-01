package SetsAndMaps.Maps;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWIthSumK {
    private static int maxLenWithSumK(int[] arr, int k){
        int maxLen = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum-k))
                maxLen = Math.max(maxLen, i-map.get(sum-k));
            if(!map.containsKey(sum)) map.put(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int k = 15;
        System.out.println("Longest subarray with sum k is of length: "+ maxLenWithSumK(arr, k));;
    }
}
