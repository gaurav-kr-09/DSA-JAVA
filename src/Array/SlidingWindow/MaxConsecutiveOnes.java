package Array.SlidingWindow;

public class MaxConsecutiveOnes {
    // BruteForce o(nsq)
    /*public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        for(int i=0; i<n; i++){
            int zeros = 0;
            int j = i;
            while (j < n && zeros != k){
                if(nums[j] == 0) zeros++;
                j++;
            }
            maxLen = Math.max(maxLen, j-i+1);
        }

        return maxLen;
    }*/

    // Optimal O(2n) i.e O(n)
    /*public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int i=0, j=0, zeros=0;

        while(j < n){
            if(nums[j] == 0) zeros++;

            while(zeros > k){
                if(nums[i] == 0) zeros--;
                i++;
            }

            j++;
            maxLen = Math.max(maxLen, j-i);

            // ya pahle  maxLen = Math.max(maxLen, j-i+1);
            // and then j++; v kar sakte hai
        }

        return maxLen;
    }*/

    // optimal O(n) even better
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int i=0, j=0, zeros=0;

        while(j < n){
            if(nums[j] == 0) zeros++;
            if(zeros > k){
                if(nums[i] == 0) zeros--;
                i++;
            }

            j++;
            maxLen = Math.max(maxLen, j-i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2; // ANS -> 6 {1,1,1,0,0,1,1,1,1,1,1}
        System.out.println("Max consecutive one by flipping k bits is: " + longestOnes(arr, k));

        int[] brr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        k =3; // ANS -> 10
        System.out.println("Max consecutive one by flipping k bits is: " + longestOnes(brr, k));
    }
}
