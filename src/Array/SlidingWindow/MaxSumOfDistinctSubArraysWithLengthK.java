package Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfDistinctSubArraysWithLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        long maxSum = 0, currSum = 0;
        int i = 0, j = 0;
        while (j < nums.length){
            currSum += nums[j];
            freq.put(nums[j], freq.getOrDefault(nums[j], 0)+1);

            if(j-i+1 > k){
                currSum -= nums[i];

                freq.put(nums[i], freq.get(nums[i])-1);

                if(freq.get(nums[i]) == 0) freq.remove(nums[i]);
                i++;
            }

            if(j-i+1 == k && freq.size() == k)
                maxSum = Math.max(maxSum, currSum);

            j++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9}; int k = 3; // 15 -> 4 2 9
        System.out.println(maximumSubarraySum(arr, k));
        int[] brr = {4,4,4}; k = 3; // ans = 0
        System.out.println(maximumSubarraySum(brr, k));
    }
}
