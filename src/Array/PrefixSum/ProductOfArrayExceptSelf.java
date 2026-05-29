package Array.PrefixSum;

public class ProductOfArrayExceptSelf {
    // METHOD 1: USING PREFIX SUFFIX ARRAY
    /*public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] pre = new int[n];
        int[] suff = new int[n];
        int[] ans = new int[n];

        pre[0] = nums[0];
        for(int i=1; i<n; i++) pre[i] = pre[i-1] * nums[i];

        suff[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) suff[i] = suff[i+1] * nums[i];

        for(int i=0; i<n; i++){
            if(i == 0) ans[i] = suff[i+1];
            else if(i == n-1) ans[i] = pre[i-1];
            else ans[i] = pre[i-1] * suff[i+1];
        }

        return ans;
    }*/

    // METHOD 2: SAME AS 1 BUT SLIGHT BETTER
    /*public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1; suff[n-1] = 1;

        for(int i=1; i<n; i++){
            pre[i] = pre[i-1] * nums[i-1];
        }

        for(int i=n-2; i>=0; i--){
            suff[i] = suff[i+1] * nums[i+1];
        }

        for(int i=0; i<n; i++){
            ans[i] = pre[i] * suff[i];
        }

        return ans;
    }*/

    // METHOD 3 : SAME IDEA BUT NO XTRA ARRAY
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int pre = 1;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = pre;
            pre *= nums[i];
        }

        int suff = 1;
        for(int i=n-1; i>=0; i--){
            ans[i] *= suff;
            suff *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3}; // 0,0,9,0,0
        int[] ans = productExceptSelf(arr);

        for(int n: ans) System.out.print(n + " ");
    }
}
