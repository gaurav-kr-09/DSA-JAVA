package Array.Kadane;

import java.util.Arrays;

public class MaxSubAraySumWithLengthDivisibleByK {
    // METHOD 1: BRUTEFORCE O(Nsq / k)
    /*public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;

        // Finding Prefix sum for calculating sum
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for(int i=1; i<n; i++) preSum[i] = preSum[i-1] + nums[i];

        // Applying bruteforce
        for(int i=0; i<n; i++){ // N
            for (int j = i+k-1; j < n; j += k) { // N/k
                long currSum = preSum[j] - ((i > 0) ? preSum[i-1] : 0);
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }*/

    // METHOD 2: OPTIMAL O(N)
    /*public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        // Finding Prefix sum for calculating sum
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for(int i=1; i<n; i++) preSum[i] = preSum[i-1] + nums[i];

        // finding maximum sum
        long maxSum = Long.MIN_VALUE;
        for(int start = 0; start<k; start++){ // check till k-1 index
            long currSum = 0;

            int i = start;
            while(i < n && i+k-1 < n){
                int j = i+k-1;
                long subSum = preSum[j] - ((i > 0) ? preSum[i-1] : 0);

                // KADANE'S ALGO
                currSum = Math.max(subSum, subSum+currSum);
                maxSum = Math.max(maxSum, currSum);

                // increasing i by k steps
                i += k;
            }

        }

        return maxSum;
    }*/

    // SAME AS 2 but cleaner
    /*public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        // Calculating prefix sum
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for(int i=1; i<n; i++) preSum[i] = preSum[i-1] + nums[i];

        // finding maximum sum
        long maxSum = Long.MIN_VALUE;
        for(int i=0; i<k; i++){
            long currSum = 0;
            for(int j=i+k-1; j<n; j += k){
                // sum of current subarray
                long subSum = preSum[j] - ((j-k >= 0) ? preSum[j-k] : 0);

                // KADANE'S ALGO - checking bigger sum
                currSum = Math.max(subSum, subSum + currSum);
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }*/

    //METHOD 3 -> NEETCODE best but not much readable
    public static long maxSubarraySum(int[] nums, int k) {
        // making an array for storing minimum prefix
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0;

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        for(int i=0; i< nums.length; i++){
            prefix += nums[i];

            int mod = (i + 1) % k;

            if(minPrefix[mod] != Long.MAX_VALUE){
                ans = Math.max(ans, prefix-minPrefix[mod]);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2}; int k = 1; // ans 3
        System.out.println(maxSubarraySum(nums, k));

        int[] brr = {-1,-2,-3,-4,-5}; k = 4; // ans -10
        System.out.println(maxSubarraySum(brr, k));

        int[] crr = {-5,1,2,-3,4}; k=2; // ans 4
        System.out.println(maxSubarraySum(crr, k));

        int[] drr = {-1,-2,3,4,-5}; k=2; // ans 7
        System.out.println(maxSubarraySum(drr, k));
    }
}