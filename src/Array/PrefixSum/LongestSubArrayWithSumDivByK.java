package Array.PrefixSum;

import java.util.HashMap;

public class LongestSubArrayWithSumDivByK {
    private static int longestSubarrayDivK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long sum = 0;
        int longest = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            int rem = (int)(sum % k);
            if(rem < 0) rem += k;

            if(map.containsKey(rem)) longest = Math.max(longest, i-map.get(rem));
            else map.put(rem, i);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 2, -5, 12, -11, -1, 7};
        int k = 3; // ANS -> 5 = 2, -5, 12, -11, -1

        System.out.println(longestSubarrayDivK(arr, k));
    }
}
