package DynamicProgramming.Tabulation;

public class ArrayPositionsToMaximizeScoreLC2786 {
    public static long maxScore(int[] nums, int x) {
        int n = nums.length;

        // i vary from n to 1 and parity from 0 to 1
        long[][] dp = new long[n+1][2];
        // bahar wala loop ulta chalega
        dp[n][0] = dp[n][1] = 0;

        for(int i=n-1; i>=1; i--){ // >= 1 kyuki 1st value to lena hi hai
            int cp = Math.abs(nums[i] % 2);
            for(int parity = 0; parity <=1; parity++){
                long pick;
                if(cp == parity) pick = nums[i] + dp[i+1][parity];
                else pick = nums[i] - x + dp[i+1][cp];

                long skip = dp[i+1][parity];

                dp[i][parity] = Math.max(pick, skip);
            }
        }

        int sp = Math.abs(nums[0] % 2); // start ka parity
        return nums[0] + dp[1][sp];
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 1, 9, 2};
        System.out.println(maxScore(nums1, 5)); // Expected: 13

        int[] nums2 = {-5, 5};
        System.out.println(maxScore(nums2, 10)); // Expected: 0

        int[] nums3 = {3, 3, 3, 3};
        System.out.println(maxScore(nums3, 3)); // Expected: 12

        int[] nums4 = {-1, -2, -3, 4, 5};
        System.out.println(maxScore(nums4, 2)); // Expected: 9

        int[] nums5 = {1, 2, -3, 4, -5, 6};
        System.out.println(maxScore(nums5, 2)); // Expected: 13
    }
}
