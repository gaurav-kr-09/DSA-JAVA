package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int lis = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]++; // current ko include kiye
            lis = Math.max(lis, dp[i]);
        }

        return lis;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums1)); // Expected: 4


        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums2)); // Expected: 4


        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums3)); // Expected: 1


        int[] nums4 = {1};
        System.out.println(lengthOfLIS(nums4)); // Expected: 1


        int[] nums5 = {5, 4, 3, 2, 1};
        System.out.println(lengthOfLIS(nums5)); // Expected: 1
    }
}