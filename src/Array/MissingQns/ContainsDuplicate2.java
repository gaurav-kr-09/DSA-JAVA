package Array.MissingQns;

import java.util.HashSet;

public class ContainsDuplicate2 {
    // BRUTEFORCE
    /*public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j= i+1; j <= i+k  && j < n; j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }*/

    // Optimal - Using HashSet
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            if(!set.add(nums[i])) return true;
            if(set.size() > k) set.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,4,1,7,3};
        int k = 3;
        System.out.println(containsNearbyDuplicate(arr, k));
    }
}
