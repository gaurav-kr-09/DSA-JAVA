package Array.Kadane;

public class MaxAbsoluteSumOfAnySubarray {
    // 2 Pass solution
    /*public static int maxAbsoluteSum(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        // Finding maximum subarray sum
        for(int i=1; i<nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        // Finding minimum subarray sum
        currSum = nums[0];
        int minSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currSum = Math.min(nums[i], currSum + nums[i]);
            minSum = Math.min(minSum, currSum);
        }

        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }*/

    // 1 Pass same as 2-pass but one loop only
    public static int maxAbsoluteSum(int[] nums) {
        int currSumMax = nums[0];
        int maxSum = nums[0];
        int currSumMin = nums[0];
        int minSum = nums[0];

        for(int i=1; i<nums.length; i++){
            // Ye hi rakhe ya naya start kare
            currSumMax = Math.max(currSumMax + nums[i], nums[i]);
            // Find maximum
            maxSum = Math.max(maxSum, currSumMax);

            currSumMin = Math.min(currSumMin + nums[i], nums[i]);
            minSum = Math.min(minSum, currSumMin);
        }

        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }

    public static void main(String[] args) {
        int[] arr = {1,-3,2,3,-4};
        System.out.println(maxAbsoluteSum(arr)); // 5
        int[] brr = {2,-5,1,-4,3,-2};
        System.out.println(maxAbsoluteSum(brr)); // 8
        int[] crr = {2,5,7,-100,-5};
        System.out.println(maxAbsoluteSum(crr)); // 105
    }
}
