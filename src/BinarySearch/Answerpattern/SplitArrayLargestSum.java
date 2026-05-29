package BinarySearch.Answerpattern;

public class SplitArrayLargestSum {
    public static int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;

        int lo = 0;
        int hi = 0;
        for(int a: arr){
            lo = Math.max(lo, a);
            hi += a;
        }

        int ans = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(isPossible(arr, mid, k)){
                ans = mid;
                hi = mid-1; // try to minimize the pages allotted
            }
            else lo = mid + 1;
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int maxAllowedPages, int students){
        int s = 1;
        int allottedPages = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxAllowedPages) return false;
            if(allottedPages + arr[i] <= maxAllowedPages) allottedPages += arr[i];
            else{
                s++;
                allottedPages = arr[i];
            }
        }

        return s <= students;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int k = 2;

        // There are four ways to split nums into two subarrays.
        // The best way is to split it into [7,2,5] and [10,8],
        // where the largest sum among the two subarrays is only 18.

        System.out.println(findPages(arr, k));

        int[] brr = {1,2,3,4,5};
        int k2 = 2;

        // There are four ways to split nums into two subarrays.
        // The best way is to split it into [1,2,3] and [4,5],
        // where the largest sum among the two subarrays is only 9.

        System.out.println(findPages(brr, k2));
    }
}