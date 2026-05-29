package Array.Kadane;

public class MaxSubArraySumCircularArray {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int maxSum = nums[0], currSumMax = 0;
        int minSum = nums[0], currSumMin = 0;
        int total = 0;

        for(int num: nums){
            currSumMax = Math.max(currSumMax + num, num);
            maxSum = Math.max(maxSum, currSumMax);

            currSumMin = Math.min(currSumMin + num, num);
            minSum = Math.min(minSum, currSumMin);

            total += num;
        }

        if(maxSum >= 0) return Math.max(maxSum, total-minSum);
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -2}; //
        System.out.println(maxSubarraySumCircular(arr));
        int[] brr = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(brr));
        int[] crr = {-3, -2, -3};
        System.out.println(maxSubarraySumCircular(crr));
    }
}