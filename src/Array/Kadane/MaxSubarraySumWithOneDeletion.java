package Array.Kadane;

public class MaxSubarraySumWithOneDeletion {
    public static int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = 0;
        int ans = arr[0];

        for(int i=1; i< arr.length; i++){
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;

            oneDelete = Math.max(prevNoDelete, prevOneDelete + arr[i]);
            noDelete = Math.max(arr[i], prevNoDelete + arr[i]);

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,0,3};
        System.out.println(maximumSum(arr)); // 4

        int[] brr = {1,-2,-2,3};
        System.out.println(maximumSum(brr)); // 3

        int[] crr = {-1,-1,-1,-1}; // -1
        System.out.println(maximumSum(crr));
    }
}