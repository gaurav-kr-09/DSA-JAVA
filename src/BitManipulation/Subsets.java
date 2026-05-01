package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // recursive version based on pick and skip recursion\
    /*public static List<List<Integer>> ans;
    public static List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        pickAndSkip(new ArrayList<>(), nums, 0);
        return ans;
    }

    public static void pickAndSkip(List<Integer> temp, int[] arr, int idx){
        if(idx == arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Pick
        temp.add(arr[idx]);
        pickAndSkip(temp, arr, idx+1);

        // BackTrack
        temp.removeLast();

        // Skip
        pickAndSkip(temp, arr, idx+1);
    }*/

    // Iterative version -> primarily based on idea of bits
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int m = 1 << n; // 2 power n, i.e no. of subsets

        for(int i = 0; i < m; i++){
            List<Integer> temp = new ArrayList<>();
            // if any set bit then add the no. at that posn in temp
            for(int j = 0; j < n; j++){
                if(((i >> j) & 1) == 1) temp.add(nums[j]);
            }
            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{2, 5, 3}));
        System.out.println(subsets(new int[]{6,9}));
    }
}
