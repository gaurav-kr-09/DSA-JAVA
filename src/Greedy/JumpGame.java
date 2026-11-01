package Greedy;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;

        int maxReach = 0;
        for(int i=0; i<n; i++){
            if(i > maxReach) return false;
            maxReach = Math.max(maxReach, i+nums[i]);
            if(maxReach >= n-1) return true;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1));
        // Expected: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2));
        // Expected: false

        int[] nums3 = {0};
        System.out.println(canJump(nums3));
        // Expected: true

        int[] nums4 = {2, 0, 0};
        System.out.println(canJump(nums4));
        // Expected: true

        int[] nums5 = {1, 0, 1, 0};
        System.out.println(canJump(nums5));
        // Expected: false
    }
}