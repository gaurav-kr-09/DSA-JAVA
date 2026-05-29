package Array.MissingQns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n; ){
                int p = j+1, q=n-1;
                while (p < q){
                    long sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if(sum < target) p++;
                    else if(sum > target) q--;
                    else{
                        ans.add(List.of(nums[i], nums[j], nums[p], nums[q]));
                        p++; q--;
                        while(p < q && nums[p] == nums[p-1]) p++;
                    }
                }

                j++;
                while(j < n && nums[j] == nums[j-1]) j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0; // Ans -> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(fourSum(arr, target));
    }
}