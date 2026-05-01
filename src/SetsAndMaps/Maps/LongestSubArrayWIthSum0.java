package SetsAndMaps.Maps;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWIthSum0 {
    private static int maxLenWithSumZero(int[] arr){
        int maxLen = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)) maxLen = Math.max(maxLen, i-map.get(sum));
            else map.put(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Longest subarray with sum 0 is of length: "+ maxLenWithSumZero(arr));;
    }
}
