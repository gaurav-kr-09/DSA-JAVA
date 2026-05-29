package Array.MissingQns;

public class TrappingRainwater {
    // Method 1: prefix Array Approach TC = SC = O(n)
    /*public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int lmx = height[0];
        for(int i=0; i<n; i++){
            lmx = Math.max(lmx, height[i]);
            leftMax[i] = lmx;
        }

        int rmx = height[n-1];
        for(int i=n-1; i>=0; i--){
            rmx = Math.max(rmx, height[i]);
            rightMax[i] = rmx;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return ans;
    }*/

    // Method 2: Two Pointer Approach TC = O(n), SC = O(1)
    /*public static int trap(int[] height) {
        int ans = 0;
        int l = 0, r = height.length-1;
        int lmax = 0, rmax = 0;

        while(l < r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if(lmax < rmax){
                ans += lmax - height[l];
                l++;
            }else{
                ans += rmax - height[r];
                r--;
            }
        }

        return ans;
    }*/

    // Method 2 but slightly better
    public static int trap(int[] height) {
        int ans = 0;
        int l = 0, r = height.length-1;
        int lmax = 0, rmax = 0;

        while(l < r){
            if(height[l] < height[r]){
                lmax = Math.max(lmax, height[l]);
                ans += lmax - height[l];
                l++;
            }else{
                rmax = Math.max(rmax, height[r]);
                ans += rmax - height[r];
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] heights1 = {0,1,0,2,1,0,1,3,2,1,2,1}; // ans = 6
        int[] heights2 = {4,2,0,3,2,5}; // ans = 9
        System.out.println("Trapped water is: " + trap(heights1));
        System.out.println("Trapped water is: " + trap(heights2));
    }
}