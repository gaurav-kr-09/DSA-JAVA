package Array.PrefixSum;

import java.util.HashMap;

public class LongestSubArrayWithSumK {
    public static int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre =0, longest = 0;
        for(int i=0; i<arr.length; i++){
            pre += arr[i];
            if(map.containsKey(pre-k))
                longest = Math.max(longest, i-(map.get(pre-k)));

            map.putIfAbsent(pre, i);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15; // ANS = 6 -> [10, 5, 2, 7, 1, -10]
        System.out.println(longestSubarray(arr, k));
        int[] brr = {-5, 8, -14, 2, 4, 12};
        k = -5; // ANS = 5 -> [-5, 8, -14, 2, 4]
        System.out.println(longestSubarray(brr, k));
    }
}