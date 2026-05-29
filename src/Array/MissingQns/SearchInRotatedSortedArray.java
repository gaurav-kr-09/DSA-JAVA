package Array.MissingQns;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[low]){ // left sorted
                if(target < nums[mid] && target >= nums[low]) high = mid-1;
                else low = mid+1;
            }else{ // right sorted
                if(target > nums[mid] && target <= nums[high]) low = mid+1;
                else high = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0)); // 4
        System.out.println(search(arr, 3)); // -1
    }
}