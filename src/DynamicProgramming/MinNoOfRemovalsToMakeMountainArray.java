package DynamicProgramming;

import java.util.Arrays;

public class MinNoOfRemovalsToMakeMountainArray {
    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        // LIS
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        for(int i=0; i<n; i++)
            for(int j=0; j<i; j++)
                if(nums[j] < nums[i]) LIS[i] = Math.max(LIS[i], LIS[j]+1);

        // LDS - ulta LIS
        int[] LDS = new int[n];
        Arrays.fill(LDS, 1);
        for(int i=n-1; i>=0; i--)
            for(int j=i+1; j<n; j++)
                if(nums[j] < nums[i]) LDS[i] = Math.max(LDS[i], LDS[j]+1);

        // calculating answer
        int minRemovals = n;
        for(int i=0; i<n; i++){
            // peak k right and left me atLeast ek element
            // hona chahiye tabhi mountain array banega
            if(LIS[i] > 1 && LDS[i] > 1)
                minRemovals = Math.min(minRemovals, n - LIS[i] - LDS[i] + 1);
        }

        return minRemovals;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 1};
        System.out.println(minimumMountainRemovals(nums1)); // Expected: 0


        int[] nums2 = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println(minimumMountainRemovals(nums2)); // Expected: 3


        int[] nums3 = {4, 3, 2, 1, 1, 2, 3, 1};
        System.out.println(minimumMountainRemovals(nums3)); // Expected: 4


        int[] nums4 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println(minimumMountainRemovals(nums4)); // Expected: 0


        int[] nums5 = {1, 2, 1, 2, 1};
        System.out.println(minimumMountainRemovals(nums5)); // Expected: 2
    }
}