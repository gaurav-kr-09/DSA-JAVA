package Array.PrefixSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IndexesOfSubarraySum {
    // OPTIMAL USING SLIDING WINDOW
    /*private static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int i = 0, j = 0;
        int sum = 0;
        while (j < arr.length){
            sum += arr[j];

            while(sum > target) sum -= arr[i++];
            if(sum == target) return new ArrayList<>(List.of(i+1, j+1));
            j++;
        }

        return new ArrayList<>(List.of(-1));
    }*/

    // OPTIMAL USING PREFIX SUM AND HASHMAP BUT EXTRA SPACE
    private static ArrayList<Integer> subarraySum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0;
        for(int i=0; i<arr.length; i++){
            pre += arr[i];
            if(map.containsKey(pre - target))
                // + 1 to start the substring and + 1 for indexing of 1 -> total +2
                return new ArrayList<>(List.of(map.get(pre - target)+2, i+1));

            map.putIfAbsent(pre, i); // to get earliest occurrence
        }

        return new ArrayList<>(List.of(-1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12; // ans 2, 4
        System.out.println(subarraySum(arr, target));

        int[] brr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        target = 15; // ans 1, 5
        System.out.println(subarraySum(brr, target));

        int[] crr = {0,0,1,4};
        target = 5; // ans 1, 4
        System.out.println(subarraySum(crr, target));
    }
}