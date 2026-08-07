package DynamicProgramming.Tabulation;

public class HouseRobber2 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int case1 = tabulation(nums, 0, n-1); // Case 1: 0 to n-1
        int case2 = tabulation(nums, 1, n); // Case 2: 1 to n

        return Math.max(case1, case2);
    }

    private static int tabulation(int[] nums, int start, int end) {
        if(start >= end) return nums[start];

        int len = end - start;
        if(len == 1) return nums[start];
        int[] dp = new int[len];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i=2; i<len; i++){
            // take, skip
            dp[i] = Math.max(nums[start + i] + dp[i-2], dp[i-1]);
        }

        return dp[len-1];
    }

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2, 3, 2}));                 // 3

        System.out.println(rob(new int[]{1, 2, 3, 1}));              // 4

        System.out.println(rob(new int[]{1, 2, 3}));                 // 3

        System.out.println(rob(new int[]{1}));                       // 1

        System.out.println(rob(new int[]{1, 2}));                    // 2

        System.out.println(rob(new int[]{2, 1, 1, 2}));              // 3

        System.out.println(rob(new int[]{200, 3, 140, 20, 10}));     // 340

        System.out.println(rob(new int[]{4, 1, 2, 7, 5, 3, 1}));     // 14
    }
}
