package SetsAndMaps.Maps;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraysWithSum {
    private static int noOfSubArrayWithSumGoal(int[] arr, int goal){
        int count = 0, sum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // to tackle if num itself is goal

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(freq.containsKey(sum-goal)) count += freq.get(sum-goal);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return count;     
    }
    
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int goal = 2;

        System.out.println("No of subarray with sum goal is: "+ noOfSubArrayWithSumGoal(arr, goal));
    }
}