package SetsAndMaps.Maps;

import java.util.ArrayList;
import java.util.HashMap;

public class MinDistBWThreeEqualElements {
    public static int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // store the index in an arrayList
        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int minDist = Integer.MAX_VALUE;
        for(int n: map.keySet()){
            ArrayList<Integer> currList = map.get(n);
            int size = currList.size();
            if(size >= 3){
                // finding minimum distance
                for(int i = 0; i < size - 2; i++){
                    // int a = currList.get(i);
                    // int b = currList.get(i+1);
                    // int c = currList.get(i+2);
                    // int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);

                    // since the list will be sorted
                    // so, b - a + c - b + c - a = 2c - 2a = 2 * (c - a)
                    int dist = 2 * Math.abs(currList.get(i+2) - currList.get(i));

                    minDist = Math.min(minDist, dist);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,2,1,2}; // ans -> 8
        System.out.println(minimumDistance(arr));
    }
}