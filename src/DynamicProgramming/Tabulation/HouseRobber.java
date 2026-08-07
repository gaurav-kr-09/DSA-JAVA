package DynamicProgramming.Tabulation;

public class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {

        System.out.println(rob(new int[]{1, 2, 3, 1}));              // 4

        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));           // 12

        System.out.println(rob(new int[]{2, 1, 1, 2}));              // 4

        System.out.println(rob(new int[]{1, 3, 1, 3, 100}));         // 103

        System.out.println(rob(new int[]{5}));                       // 5

        System.out.println(rob(new int[]{2, 1}));                    // 2

        System.out.println(rob(new int[]{2, 1, 1, 2, 5, 1}));        // 8

        System.out.println(rob(new int[]{6, 6, 4, 8, 4, 3, 3, 10})); // 27
    }
}