package Array.DifferenceArray;

public class ZeroArrayTransformation2 {
    // Method 1: BruteForce TC O(n * q)
    /*public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        // Checking if array is already 0 array
        boolean allZero = true;
        for(int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if(allZero) return 0;

        // check for how many query it will be 0 array
        for(int i=0; i<q; i++){
            if(checkWithDiffArray(nums, queries, i)) return i+1;
        }

        return -1;
    }*/

    // helper function
    private static boolean checkWithDiffArray(int[] nums, int[][] queries, int k) {
        int n = nums.length;

        int[] diff = new int[n];
        for (int i = 0; i <= k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] += val;
            if (r + 1 < n) diff[r + 1] -= val;
        }

        for (int i = 1; i < n; i++) diff[i] += diff[i - 1];

        for (int i = 0; i < n; i++) {
            if (nums[i] > diff[i]) return false;
        }

        return true;
    }

    // Optimal using binary search
    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        // Checking if array is already 0 array
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) return 0;

        // check for how many query it will be 0 array
        int lo = 0, hi = q - 1;
        int k = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (checkWithDiffArray(nums, queries, mid)) {
                k = mid + 1;
                hi = mid - 1;
            } else lo = mid + 1;
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2};
        int[][] queries = {{0,2,1},{0,2,1},{1,1,3}}; // 2
        System.out.println(minZeroArray(nums, queries));

        int[] nums2 = {4,3,2,1};
        int[][] queries2 = {{1,3, 2},{0,2, 1}}; // -1
        System.out.println(minZeroArray(nums2, queries2));
    }
}