package Greedy;

public class JumpGameII {
    // Galat Approach
    /*public static int jump(int[] nums) {
        int n = nums.length;

        int maxReach = 0;
        int ans = n;
        for(int i=0; i<n; i++){
            maxReach = Math.max(maxReach, i+nums[i]);
            if(maxReach >= n-1) ans = Math.min(ans, i+1);
        }

        return ans;
    }*/

    // Sahi approach
    public static int jump(int[] nums) {
        int n = nums.length;

        int jumps = 0;
        int l = 0, r = 0;
        while(r < n-1){ // last ya bahar
            int farthest = 0;

            for(int i=l; i<=r; i++)
                farthest = Math.max(farthest, i + nums[i]);

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(jump(nums1));
        // Expected: 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(jump(nums2));
        // Expected: 2

        int[] nums3 = {1, 2, 3};
        System.out.println(jump(nums3));
        // Expected: 2

        int[] nums4 = {4, 1, 1, 3, 1, 1, 1};
        System.out.println(jump(nums4));
        // Expected: 2

        int[] nums5 = {1};
        System.out.println(jump(nums5));
        // Expected: 0
    }
}