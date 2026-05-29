package Array.MissingQns;

public class MinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int low = 0, high = n- 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            if(nums[low] < nums[high]) ans = Math.min(ans, nums[low]);

            int mid = low + (high - low) / 2;
            ans = Math.min(ans, nums[mid]);

            if(nums[low] <= nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int[] brr = {11,13,15,17};

        System.out.println("Minimum in arr is: " + findMin(arr)); // 0
        System.out.println("Minimum in brr is: " + findMin(brr)); // 11
    }
}
