package Array.SlidingWindow;

// LC -> 1658
public class MinOprnToReduceXto0 {
    // BASIC RECURSION -> TC 2 pow(n+n)
    /*public static int minOperations(int[] nums, int x) {
        int ans = steps(0, nums.length-1, nums, x);
        return ans >= 1e6 ? -1: ans;
    }

    public static int steps(int i, int j, int[] nums, int x){
        if(x == 0) return 0; // x 0 ho gaya, means no elements needed
        if(i > j || x < 0) return (int)1e6; // max answer 10^5 ho sakta hai so impossible k liye use kiye 10^6
        int takeF = 1 + steps(i+1, j, nums, x-nums[i]);
        int takeB = 1 + steps(i, j-1, nums, x-nums[j]);

        return Math.min(takeF, takeB);
    }*/

    // MEMOIZED - but ye MLE Dega 100000 input pe kyuki req. memory = 10^10 so ye v fail
    /*public static int minOperations(int[] nums, int x) {
        int n = nums.length;

        // i -> 0 to n-1 | j -> 0 to n-1
        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = steps(0, n-1, nums, x, dp);
        return ans >= 1e6 ? -1: ans;
    }

    public static int steps(int i, int j, int[] nums, int x, int[][] dp){
        if(x == 0) return 0; // x 0 ho gaya, means no elements needed
        if(i > j || x < 0) return (int)1e6;

        if(dp[i][j] != -1) return dp[i][j];

        int takeF = 1 + steps(i+1, j, nums, x-nums[i], dp);
        int takeB = 1 + steps(i, j-1, nums, x-nums[j], dp);

        return dp[i][j] = Math.min(takeF, takeB);
    }*/

    // iska optimal solution sliding window se hoga - dekho
    // hame chahiye smallest (left + right) jiska sum x ho,
    // to agar ham aisa longest subArray dhundh le jiska sum
    // (totalSum - x) k barabar ho to bat ban jayega, jo ki
    // ham easily nikal sakte hai sliding window se
    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int tSum = 0;
        for(int num: nums) tSum += num;
        if(tSum == x) return n; // agar total ka sum hoga x to total return karna parega
        if(tSum < x) return -1; // sum possible hi nahi hai

        // SLIDING WINDOW
        int target = tSum - x;
        int maxLen = -1;
        int cSum = 0;
        int i = 0;
        for(int j = 0; j <n; j++){
            cSum += nums[j];
            while (i <= j && cSum > target){
                cSum -= nums[i];
                i++;
            }

            if(cSum == target) maxLen = Math.max(maxLen, j-i+1);
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 4, 2, 3};
        int x1 = 5;
        System.out.println(minOperations(nums1, x1)); // Expected: 2

        int[] nums2 = {5, 6, 7, 8, 9};
        int x2 = 4;
        System.out.println(minOperations(nums2, x2)); // Expected: -1

        int[] nums3 = {3, 2, 20, 1, 1, 3};
        int x3 = 10;
        System.out.println(minOperations(nums3, x3)); // Expected: 5

        int[] nums4 = {1, 1, 1, 1, 1};
        int x4 = 3;
        System.out.println(minOperations(nums4, x4)); // Expected: 3

        int[] nums5 = {1, 2, 3};
        int x5 = 6;
        System.out.println(minOperations(nums5, x5)); // Expected: 3
    }
}