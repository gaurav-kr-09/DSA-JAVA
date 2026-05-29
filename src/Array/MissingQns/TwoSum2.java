package Array.MissingQns;

public class TwoSum2 {
    // Method 1: O(nLogN)
    /*public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            int presIdx = search(nums, target-nums[i], i+1, n-1);
            if(presIdx != -1) return new int[]{i+1, presIdx+1};
        }

        return new int[]{-1, -1};
    }

    public static int search(int[] arr, int tar, int lo, int hi){
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == tar) return mid;

            if(arr[mid] < tar) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }*/

    // Method 2: O(n)
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i=0, j=n-1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target) return new int[]{i+1, j+1};
            if(sum < target) i++;
            else j--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,5,9,15,25,40};
        int[] ans = twoSum(arr, 20);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
