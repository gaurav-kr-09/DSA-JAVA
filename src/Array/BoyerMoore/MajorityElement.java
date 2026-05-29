package Array.BoyerMoore;

public class MajorityElement {
    // using hashmap -> O(n) space
    /*public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            int currFreq = map.getOrDefault(num, 0);
            map.put(num, currFreq+1);
            if(currFreq + 1 > nums.length/2) return num;
        }

        return -1;
    }*/

    // METHOD 2: OPTIMAL O(1) space
    public static int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 1;

        for(int i=1; i<nums.length; i++){
            // if(nums[i] == maj) count++;
            // else if(count == 0){
            //     maj = nums[i];
            //     count = 1;
            // }
            // else count--;

            if(count == 0){
                maj = nums[i];
            }

            if(nums[i] == maj) count++;
            else count--;
        }

        // SINCE MAJORITY ELEMENT IS GUARANTEED SO NO VERIFICATION NEEDED

        return maj;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr)); // 2
    }
}
