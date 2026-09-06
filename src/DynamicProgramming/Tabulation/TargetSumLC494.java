package DynamicProgramming.Tabulation;

public class TargetSumLC494 {
    // PURANA TARIKA and  Without space optimization
    /*public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum += num;

        if(Math.abs(target) > sum) return 0; // jab target sum se bada to no way

        // i vary from n to 0 | cSum from -sum to sum
        // j is representing sum not target
        // 0th index -sum, sum 0th index
        int[][] dp = new int[n + 1][2 * sum + 1];
        for (int j = 0; j <= 2 * sum; j++) dp[0][j] = 0; // 0 elements se koi sum nahi ban sakta
        dp[0][sum] = 1; // but 0 elements se sum 0 ban sakta hai -> sum = 0, sumth index pe hoga

        for(int i=1; i<=n; i++){
            for(int j=0; j<=2*sum; j++){
                int plus = 0;
                if (j + nums[i - 1] <= 2 * sum)
                    plus = dp[i - 1][j + nums[i - 1]]; // ways(n-1, nums, cSum + nums[n-1], target, dp);

                int minus = 0;
                if (j - nums[i - 1] >= 0)
                    minus = dp[i - 1][j - nums[i - 1]]; // ways(n-1, nums, cSum - nums[n-1], target, dp)

                dp[i][j] = plus + minus;
            }
        }

        return dp[n][target+sum]; // we need count of target + sum -> sum 0th index pe hoga actual me
        // target ka actual sum, offset ki wajah se target + sum index par hai
    }*/

    // BETTER WAY AND - Reducing problem to subset sum problem
    // Without space optimization
    /*public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for(int num: nums) sum += num;

        if(Math.abs(target) > sum) return 0;
        if((target + sum) % 2 != 0) return 0;

        int newTarget = (target + sum) / 2;

        // i vary from 0 to n and newTarget from 0 to newTarget
        int[][] dp = new int[n+1][newTarget+1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1; // 0 sum always possible in 1 way - take no item
        // but koi aage ka element v 0 hi rahe to no. of ways to get 0 sum badal sakta hai
        // so andar wale loop ko 0 se start karo
        for(int j = 1; j <=newTarget; j++) dp[0][j] = 0; // impossible to get sum > 0 with no item

        for(int i=1; i<=n; i++) {
            for (int j = 0; j <= newTarget; j++) {
                int pick = 0;
                if(j >= nums[i-1]) // target >= nums[n-1]
                    pick = dp[i-1][j-nums[i-1]]; // ways(n-1, nums, target-nums[n-1], dp);

                int skip = dp[i-1][j]; // ways(n-1, nums, target, dp);
                dp[i][j] = pick + skip;
            }
        }

        return dp[n][newTarget];
    }*/

    // SPACE OPTIMIZED
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for(int num: nums) sum += num;

        if(Math.abs(target) > sum) return 0;
        if((target + sum) % 2 != 0) return 0;

        int newTarget = (target + sum) / 2;

        // newTarget vary from 0 to newTarget
        int[] dp = new int[newTarget+1];
        // for(int j = 1; j <=newTarget; j++) dp[j] = 0; // impossible to get sum > 0 with no item // unnecessary
        dp[0] = 1; // 0 sum always possible in 1 way - take no item

        for(int i=1; i<=n; i++) {
            for (int j = newTarget; j >= nums[i-1]; j--) {
                int pick = dp[j-nums[i-1]]; // ways(n-1, nums, target-nums[n-1], dp);
                int skip = dp[j]; // ways(n-1, nums, target, dp);
                dp[j] = pick + skip;
            }
        }

        return dp[newTarget];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums1, 3)); // Expected: 5

        int[] nums2 = {1};
        System.out.println(findTargetSumWays(nums2, 1)); // Expected: 1

        int[] nums3 = {1};
        System.out.println(findTargetSumWays(nums3, 2)); // Expected: 0

        int[] nums4 = {2, 2, 2, 2};
        System.out.println(findTargetSumWays(nums4, 0)); // Expected: 6

        int[] nums5 = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(findTargetSumWays(nums5, 1)); // Expected: 256

        int[] nums6 = {1, 2, 3, 4, 5};
        System.out.println(findTargetSumWays(nums6, 3)); // Expected: 3
    }
}
