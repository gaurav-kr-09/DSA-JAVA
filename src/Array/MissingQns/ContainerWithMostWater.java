package Array.MissingQns;

public class ContainerWithMostWater {
    // Method 1: bruteforce O(NSq) Will give TLE
    /*public static int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int min = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, (j-i)*min);
            }
        }
        return maxArea;
    }*/

    // Method 2: optimal O(N)
    public static int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i=0, j=n-1;
        while(i < j){
            if(height[i] < height[j]){
                maxArea = Math.max(maxArea, height[i]*(j-i));
                i++;
            }else {
                maxArea = Math.max(maxArea, height[j]*(j-i));
                j--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7}; // 49
        System.out.println("Maximum area of container is: "+maxArea(heights));
    }
}
