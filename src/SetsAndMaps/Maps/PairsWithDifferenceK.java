package SetsAndMaps.Maps;

import java.util.HashMap;

public class PairsWithDifferenceK {
    private static int countKDifference(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n: nums){
            if(map.containsKey(n-k)) count += map.get(n-k);
            if(map.containsKey(n+k)) count += map.get(n+k);

            map.put(n, map.getOrDefault(n, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        int k = 1; // ans= 4
        System.out.println("No. of pairs with difference k is: "+ countKDifference(arr, k));
    }
}
