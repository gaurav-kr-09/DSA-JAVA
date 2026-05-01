package SetsAndMaps.Sets;

import java.util.HashSet;

public class TwoSumGFG {
    private static boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr){
            int rem = target - ele;
            if(set.contains(rem)) return true;
            set.add(ele);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,8,4,2};
        int target = 5;
        System.out.println(twoSum(arr, target) ? "target sum is in arr": "target sum is not in array");
    }
}