package Array.Kadane;

public class MaximumSubArrayLC53 {
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
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4}; // ANS 6
        System.out.println("Maximum subarray is: "+ maxSubArray(arr));
    }
}