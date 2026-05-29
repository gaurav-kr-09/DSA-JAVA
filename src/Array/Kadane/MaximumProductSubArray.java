package Array.Kadane;

public class MaximumProductSubArray {
    // BRUTEFORCE
    /*public static int maxProduct(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int prod = 1;
            for(int j=i; j<n; j++){
                prod *= nums[j];
                max = Math.max(max, prod);
            }
        }

        return max;
    }*/

    // OPTIMAL USING KADANE ALGO
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = Integer.MIN_VALUE;

        for(int i=1; i< nums.length; i++){
            int curr = nums[i];
            int prevMax = max;
            max = Math.max(curr, Math.max(curr*max, curr*min));
            min = Math.min(curr, Math.min(curr*prevMax, curr*min));

            ans = Math.max(max, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4,5,1,0,-2,8}; // ans -> 20
        int[] brr = {5,3,1,-2,0,-5,8,-3}; // ans -> 120
        System.out.println("Maximum product of subarray is: " + maxProduct(arr));
        System.out.println("Maximum product of subarray is: " + maxProduct(brr));
    }
}
