package CountBucketRadixSort;

public class ShortestUnsortedContinuousSubArray {
    // Method 1: NlogN and extra linear space
    /*public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);

        Arrays.sort(copy);

        int x = -1, y = -1;
        for(int i=0; i<n; i++){
            if(nums[i] != copy[i]){
                if(x == -1) x=i;
                y=i;
            }
        }

        return x == -1 ? 0 : y-x+1;
    }*/

    // Method 2: Optimal O(N)
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int start = -1, end = -1;
        int maxSoFar = nums[0];
        int minSoFar = nums[n-1];

        // left to right (should be increasing)
        for(int i=1; i<n; i++){
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if(nums[i] < maxSoFar) end = i;
        }

        // right to left (should be decreasing)
        for(int i=n-2; i>=0; i--){
            minSoFar = Math.min(minSoFar, nums[i]);
            if(nums[i] > minSoFar) start = i;
        }

        if(start == -1 || end == -1) return 0;
        return end-start+1;
    }

    public static void main(String[] args) {
        int[] arr = {2,6,4,8,10,9,15}; // ans = 5 -> 6,4,8,10,9
        System.out.println(" length of continuous subarray to be sorted is: " + findUnsortedSubarray(arr));
    }
}
