package Array.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum=0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (freq.containsKey(sum - k)) count += freq.get(sum - k);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k = 2; // ANS = 2
        System.out.println(subarraySum(arr, k));
    }
}
