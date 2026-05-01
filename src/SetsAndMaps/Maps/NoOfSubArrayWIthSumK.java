package SetsAndMaps.Maps;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubArrayWIthSumK {
    private static int noOfSubarray(int[] arr, int k){
        int count = 0, sum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // to tackle if num itself is k

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(freq.containsKey(sum-k)) count += freq.get(sum-k);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;
        System.out.println("NO. of subarray with sum k is: "+ noOfSubarray(arr, k));;
    }
}
