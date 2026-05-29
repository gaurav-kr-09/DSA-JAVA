package Array.PrefixSum;

import java.util.HashMap;

public class SubArraysWithSumDivisibleByK {
    // METHOD 1: BRUTEFORCE
    /*public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // convert nums to prefix sum
        for(int i=1; i<n; i++) nums[i] += nums[i-1];

        // counting no. of required subarrays
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = i == 0 ? nums[j] : nums[j] - nums[i-1];

                if(sum%k == 0) count++;
            }
        }

        return count;
    }*/

    // METHOD 2: OPTIMAL
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            int rem = sum % k;
            if(rem < 0) rem += k;

            if(map.containsKey(rem)) count += map.get(rem);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,0,2,3,1}; // 4,5,0,-2,-3,1
        int k = 5;
        // ANS -> There are 7 subarrays with a sum divisible by k = 5:
        // [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
        System.out.println(subarraysDivByK(arr, k));
    }
}