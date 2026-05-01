package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // Method 1: good TC O(n!) sc high
    /*public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private static void helper(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] used) {
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                temp.add(nums[i]);
                used[i] = true;
                helper(nums, ans, temp, used);
                used[i] = false;
                temp.removeLast();
            }
        }
    }*/

    // Method 2: good TC O(n!) but sc low
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }

    private static void helper(int[] nums, int idx, List<List<Integer>> ans){
        if(idx == nums.length - 1){
            List<Integer> temp = new ArrayList<>();
            for(int n: nums) temp.add(n);
            ans.add(temp);
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(i, idx, nums);
            helper(nums, idx+1, ans);
            swap(i, idx, nums);
        }
    }

    private static void swap(int i, int idx, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }
}