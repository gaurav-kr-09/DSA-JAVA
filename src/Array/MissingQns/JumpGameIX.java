package Array.MissingQns;

public class JumpGameIX {
    // Method 1: optimal
    /*public static int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] preMax = new int[n];
        int[] sufMin = new int[n];

        preMax[0] = nums[0];
        for(int i=1; i<n; i++) preMax[i] = Math.max(preMax[i-1], nums[i]);

        sufMin[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) sufMin[i] = Math.min(sufMin[i+1], nums[i]);

        ans[n-1] = preMax[n-1];
        for(int i=n-2; i >= 0; i--){
            // if(preMax[i] > sufMin[i+1]) ans[i] = ans[i+1];
            // else ans[i] = preMax[i];

            // In dono line ki jagah niche wala use kar sakte hai in fact niche wala better hai.

             ans[i] = preMax[i];
             if(preMax[i] > sufMin[i+1]) ans[i] = ans[i+1];
        }

        return ans;
    }*/

    // Method 2: same as 1 but 1 calculating sufmin on the fly
    public static int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] preMax = new int[n];

        preMax[0] = nums[0];
        for(int i=1; i<n; i++) preMax[i] = Math.max(preMax[i-1], nums[i]);

        int sufMin = Integer.MAX_VALUE;
        for(int i=n-1; i >= 0; i--){
            if(preMax[i] > sufMin) ans[i] = ans[i+1];
            else ans[i] = preMax[i];

            sufMin = Math.min(sufMin, nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,7,6}; // 2 2 3 5 5 7 7
        int[] ans = maxValue(arr);
        for(int a: ans){
            System.out.print(a + " ");
        }
    }
}
