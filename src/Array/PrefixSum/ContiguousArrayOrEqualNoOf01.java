package Array.PrefixSum;

import java.util.HashMap;

public class ContiguousArrayOrEqualNoOf01 {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int longest = 0, sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += (nums[i] == 1) ? 1 : -1;

            if(map.containsKey(sum)) longest = Math.max(longest, i- map.get(sum));
            else map.put(sum, i);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0,1,1};
        // ANS = 6 -> 1,0,0,1,0,1 OR 0,0,1,0,1,1
        System.out.println(findMaxLength(arr));
    }
}