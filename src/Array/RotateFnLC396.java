package Array;

public class RotateFnLC396 {
    // Brute force O(nsq)
    /*public static int maxRotateFunction(int[] nums) {
        int maxRes = Integer.MIN_VALUE, n = nums.length;
        for(int i = 0; i < n; i++){
            int ans = 0;
            for(int j = 0; j < n; j++){
                ans += j * nums[(j+i) % n];
            }
            maxRes = Math.max(maxRes, ans);
        }
        return maxRes;
    }*/

    // optimized using recurrence relation O(n)
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length, sum=0, f=0;

        // initial calculation
        for(int i=0; i<n; i++){
            sum += nums[i];
            f += (i * nums[i]);
        }

        // another terms

        int maxRes = f;
        for(int i=1; i< n; i++){
            f = f + sum - n * nums[n-i];
            maxRes = Math.max(maxRes, f);
        }
        return maxRes;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(arr)); // ans 26
    }
}
