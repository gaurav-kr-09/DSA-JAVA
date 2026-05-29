package Array.Kadane;

public class KConcatenationMaxSum {
    // METHOD 1 - optimal but long
    /*public static int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        long total = 0;
        for(int a: arr) total += a;

        long ans;
        if(k == 1) ans = kadaneOf1(arr);
        else if(total <= 0) ans = kadaneOf2(arr);
        else ans = kadaneOf2(arr) + (long)(k-2) * total;

        return (int)(ans % 1000000007);
    }

    private static long kadaneOf1(int[] arr){
        long maxSum = 0, currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = Math.max(arr[i], currSum+arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    private static long kadaneOf2(int[] arr){
        int n = arr.length;
        long maxSum = 0, currSum = 0;
        for (int i = 0; i < 2*n; i++) {
            int currVal = arr[i % n];
            currSum = Math.max(currVal, currSum+currVal);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }*/

    // METHOD 2 - optimal and short
    public static int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        long total = 0;
        for(int a: arr) total += a;

        long maxSum = 0, currSum = 0;
        int times = Math.min(k, 2); // agar k 1 hua to
        for (int i = 0; i < n*times; i++) {
            int currVal = arr[i % n];
            currSum = Math.max(currVal, currSum+currVal);
            maxSum = Math.max(maxSum, currSum);
        }

        if(total > 0 && k > 2) maxSum += (k-2)*total;
        return (int)(maxSum % 1000000007L);
    }

    public static void main(String[] args) {
        int[] arr = {1,2}; int k = 3; // 9
        System.out.println(kConcatenationMaxSum(arr, k));
        int[] brr = {1,-2,1}; k=5; // 2
        System.out.println(kConcatenationMaxSum(brr, k));
        int[] crr = {-1,-2}; k=7; // 0
        System.out.println(kConcatenationMaxSum(crr, k));
        int[] drr = {1,2}; k=1; // 3
        System.out.println(kConcatenationMaxSum(drr, k));
    }
}
