package BinarySearch;

public class MinInRotatedSortedArrayLC153 {
    // Method 1: Linear Search TC O(n)
    /*public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
        }
        return min;
    }*/

    // Method 2: Binary Search optimal TC O(logN)
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while (low <= high){
            // Array is sorted
            if(nums[low] < nums[high]) return Math.min(min, nums[low]);

            int mid = low + (high-low) / 2;
            min = Math.min(min, nums[mid]);
            // right part is increasing sorted
            if(nums[mid] < nums[high]) high = mid-1;
            else low = mid+1;
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2}; // ANS -> 0
        System.out.println("Minimum is: " + findMin(arr));
    }
}