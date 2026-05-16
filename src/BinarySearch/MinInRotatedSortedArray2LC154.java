package BinarySearch;

public class MinInRotatedSortedArray2LC154 {
    // Method 1: Linear Search TC O(n)
    /*public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
        }
        return min;
    }*/

    // Method 2: Binary Search optimal TC O(logN)
    /*public static int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int min = Integer.MAX_VALUE;

        while (low <= high){
            // SKIPPING DUPLICATES
            while (low < high && nums[low] == nums[low+1]) low++;
            while (high > low && nums[high] == nums[high-1]) high--;

            // Finding Minimum
            if(nums[low] < nums[high]) return nums[low];

            int mid = low + (high-low)/2;
            min = Math.min(min, nums[mid]);

            if(nums[mid] < nums[high]) high = mid;
            else low = mid+1;
        }

        return min;
    }*/

    // Method 3: Binary Search optimal and slight better reading TC O(logN)
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] < nums[high]) high = mid; // not mid-1 coz mid can be min
            else if(nums[mid] > nums[high]) low = mid+1;
            else high--; // dono barabar hai to naya mid dhundhte hai
        }

        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,0,0,1,1,1}; // ANS -> 0
        System.out.println("Minimum is: " + findMin(arr));

        int[] brr = {3,3,3,3,1,3}; // ANS -> 1
        System.out.println("Minimum is: " + findMin(brr));

        int[] crr = {10,1,10,10,10}; // ANS -> 1
        System.out.println("Minimum is: " + findMin(crr));

        int[] drr = {1,2,0,0,1}; // ANS -> 0
        System.out.println("Minimum is: " + findMin(drr));
    }
}