package Array.MissingQns;

public class MaximumSubArray {
    // BruteForce - O(nsq)
    /*public static int maxSubArray(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }*/

    // Optimal -  O(n)
    /*public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(currSum < 0) currSum = 0;
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }*/

    // USING KADANE'S ALGO
    public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum subarray is: "+ maxSubArray(arr));
    }
}