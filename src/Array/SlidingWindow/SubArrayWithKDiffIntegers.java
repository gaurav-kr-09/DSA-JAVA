package Array.SlidingWindow;

import java.util.HashMap;

public class SubArrayWithKDiffIntegers {
    // Method 1: 2 pass solution optimal TC(O(N)) SC(O(k))
    /*public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private static int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0, j=0;
        int ans = 0;
        while(j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            while(map.size() > k){
                int freq = map.get(nums[i]);
                if(freq == 1) map.remove(nums[i]);
                else map.put(nums[i], freq-1);
                i++;
            }

            ans += (j-i+1);
            j++;
        }

        return ans;
    }*/

    // Method 2: 1 pass solution optimal TC(O(N)) SC(O(k))
    public static int subarraysWithKDistinct(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0, j=0, iBig = 0;
        int ans = 0;

        while (j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            // Handling invalid subarray i.e shrink
            while (map.size() > k){
                int freq = map.get(nums[i]);
                if(freq == 1) map.remove(nums[i]);
                else map.put(nums[i], freq-1);

                i++;
                iBig = i;
            }

            // handle to find the smallest subarray ending at j by shrinking
            // i.e. Remove extra duplicates from left
            while(map.get(nums[i]) > 1){
                map.put(nums[i], map.get(nums[i])-1);
                i++;
            }

            if(map.size() == k) ans += (1 + i - iBig);

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2; // ANS 7
        System.out.println(subarraysWithKDistinct(arr, k));

        int[] brr = {1,2,1,3,4};
        k = 3; // ANS 3
        System.out.println(subarraysWithKDistinct(arr, k));
    }
}
