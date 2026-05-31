package Array.DifferenceArray;

public class ZeroArrayTransformation1 {
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        // Step 1: Make a difference array of what need to be subtracted
        int[] diff = new int[n];
        for(int[] query: queries){
            int l = query[0], r = query[1];
            diff[l] += 1;
            if(r+1 < n) diff[r+1] -= 1;
        }

        // Step 2: take cumulative sum
        for(int i=1; i<n; i++) diff[i] += diff[i-1];

        // Step 3: check if nums[i] - diff[i] <= 0, i.e diff[i] >= nums[i] else false
        for(int i=0; i<n; i++){
            if(diff[i] < nums[i]) return false; // 0 or less kar hi nahi payega
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        int[][] queries = {{0,2}}; //true
        System.out.println(isZeroArray(nums, queries));

        int[] nums2 = {4,3,2,1};
        int[][] queries2 = {{1,3},{0,2}}; // false
        System.out.println(isZeroArray(nums2, queries2));
    }
}