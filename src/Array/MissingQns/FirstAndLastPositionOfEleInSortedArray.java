package Array.MissingQns;

public class FirstAndLastPositionOfEleInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int fap = search(nums, target, true);
        int lap = search(nums, target, false);
        return new int[]{fap, lap};
    }

    public static int search(int[] nums, int target, boolean fap){
        int n = nums.length;
        int res = -1;
        int low =0, high =n-1;
        while (low <= high){
            int mid = low + (high-low) / 2;
            if(nums[mid] > target) high = mid-1;
            else if(nums[mid] < target) low = mid+1;
            else{
                res = mid;
                if(fap) high = mid-1;
                else low = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = searchRange(arr, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}