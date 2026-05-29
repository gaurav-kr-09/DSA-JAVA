package Array.BoyerMoore;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    // using hashmap -> O(n) space
    /*public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 0)+1);

        for(int key: map.keySet()){
            if(map.get(key) > nums.length/3) ans.add(key);
        }

        return ans;
    }*/

    // METHOD 2: OPTIMAL O(1) space
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;;
        int maj1 = 0, count1 = 0;
        int maj2 = 0, count2 = 0;

        for(int i=0; i < n; i++){
            if(nums[i] == maj1) count1++;
            else if (nums[i] == maj2) count2++;
            else if(count1 == 0){
                maj1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                maj2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        // VERIFICATION NEEDED -- Since not guaranteed
        int freq1 = 0, freq2 = 0;
        for(int num: nums){
            if(num == maj1) freq1++;
            else if(num == maj2) freq2++;
        }

        List<Integer> ans = new ArrayList<>();
        if(freq1 > n / 3) ans.add(maj1);
        if(freq2 > n/3) ans.add(maj2);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,3,1,4,5,6};
        System.out.println(majorityElement(arr)); // 2

        int[] brr = {2,1,1,2,2,2,1,1,3,5,4};
        System.out.println(majorityElement(brr)); // 2, 1
    }
}
