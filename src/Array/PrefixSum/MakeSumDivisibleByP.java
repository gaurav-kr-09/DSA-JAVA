package Array.PrefixSum;

import java.util.HashMap;

public class MakeSumDivisibleByP {
    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums){
            // sum += num; // aise me sum ko long karna parega
            sum = (sum + num) % p;
        }

        int target = sum % p;
        // YANI KI HAMKO minimum SUBARRAY dhundhna hai
        // jiska sum target ho ya target * k ho k->[1,inf)

        if(target == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0, minLen = n;
        for(int i=0; i< n; i++){
            currSum = (currSum + nums[i]) % p;

            int toFind = (currSum - target + p) % p;
            if(map.containsKey(toFind)) minLen = Math.min(minLen, i-map.get(toFind));

            map.put(currSum, i);
        }

        return (minLen == n) ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,5,2};
        int p = 9; // ANS -> 2 [5, 2]
        System.out.println(minSubarray(arr, p));
    }
}