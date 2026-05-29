package Array.MissingQns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // Bruteforce O(nCube) bekar
    /*public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n ; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]); temp.add(nums[j]); temp.add(nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }*/

    // Bruteforce O(nSq) better
    /*public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            int tar = -nums[i];
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int newTar = tar - nums[j];
                if(hs.contains(newTar)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); temp.add(nums[j]); temp.add(newTar);
                    Collections.sort(temp);
                    set.add(temp);
                }
                hs.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }*/

    // Optimal using two pointers
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue; // ignoring duplicates

            int j=i+1, k=n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) j++;
                else if (sum > 0) k--;
                else{
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++; k--;

                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
