package Array;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    // BruteForce
    /*public static int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int mid = nums[n/2];

        int ans = 0;
        for(int num: nums){
            ans += Math.abs(num - mid);
        }

        return ans;
    }*/

    // BruteForce but better
    public static int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int mid = nums[n/2];

        int ans = 0;
        for(int i=0; i<n/2; i++){
            ans += mid - nums[i]; // aage wala chhota hoga
            ans += nums[n-1-i] - mid; // pichhe wala bada hoga
        }

        return ans;
    }

    // ISKA OPTIMAL SOLUTION V SAME HI HAI BAS SORTING ME NlogN TIME
    // LAGANE SE BADHIYA QUICKSELECT SE Nth ELEMENT NIKAL LETE HAI
    // USSE APPROX O(N) ME NIKAL JAYEGA AND FIR O(N) ME ANSWER NIKALNA
    // TO APPROX O(N) ME HO JAYEGA KAM


    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        System.out.println(minMoves2(nums1));
        // Expected: 2

        int[] nums2 = {1, 10, 2, 9};
        System.out.println(minMoves2(nums2));
        // Expected: 16

        int[] nums3 = {1, 0, 0, 8, 6};
        System.out.println(minMoves2(nums3));
        // Expected: 14
    }
}