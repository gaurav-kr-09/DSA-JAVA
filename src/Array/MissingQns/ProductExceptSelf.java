package Array.MissingQns;

import java.util.Arrays;

public class ProductExceptSelf {
    // Brute force -> TC O(nsq)
    /*public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int temp = 1;
            for(int j=0; j<n; j++){
                if(i == j) continue;
                temp *= nums[j];
            }
            ans[i] = temp;
        }
        return ans;
    }*/

    // prefix and postfix based
    /*public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];
        int[] post= new int[n];
        pre[0] = 1; post[n-1] = 1;

        for(int i=1; i<n; i++){
            pre[i] = pre[i-1] * nums[i-1];
        }

        for(int i=n-2; i>=0; i--){
            post[i] = post[i+1] * nums[i+1];
        }

        for(int i=0; i<n; i++){
            ans[i] = pre[i] * post[i];
        }

        return ans;
    }*/

    // Optimized prefix and postfix based
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);

        int pre = 1, post = 1;
        for(int i=0; i<n; i++){
            ans[i] = pre;
            pre = ans[i] * pre;
        }

        for(int i=n-1; i>=0; i--){
            ans[i] = ans[i] * post;
            post = post * nums[i];
        }
  
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5};
        int[] ans = productExceptSelf(arr);
        for(int num: ans) System.out.print(num + " ");
    }
}