package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LISPatienceSorting {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        List<Integer> sorted = new ArrayList<>();
        for(int i=0; i<n; i++){
            int ijg = findJustGreater(sorted, nums[i]); // Index Of Just Greater
            if (ijg == sorted.size()) sorted.add(nums[i]);
            else sorted.set(ijg, nums[i]);
        }

        return sorted.size();
    }

    public static int findJustGreater(List<Integer> arr, int target){
        int n = arr.size();
        int lo = 0, hi = n-1;
        int ans = n; // sab chhota hua to last me hoga answer
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr.get(mid) >= target){
                ans = mid;
                hi = mid-1; // aur chhota dhundh jo bada ho
            }
            else lo = mid+1;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums1)); // Expected: 4
        // LIS: 2, 3, 7, 101


        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums2)); // Expected: 4
        // LIS: 0, 1, 2, 3


        int[] nums3 = {7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums3)); // Expected: 1


        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println(lengthOfLIS(nums4)); // Expected: 5


        int[] nums5 = {5, 4, 3, 2, 1};
        System.out.println(lengthOfLIS(nums5)); // Expected: 1


        int[] nums6 = {2, 2, 2, 2, 3};
        System.out.println(lengthOfLIS(nums6)); // Expected: 2
    }
}