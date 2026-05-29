package BinarySearch.Answerpattern;

public class BookAllocationProblem {
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
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        // Allocation can be done in following ways:
        // => [12] and [34, 67, 90] Maximum Pages = 191
        // => [12, 34] and [67, 90] Maximum Pages = 157
        // => [12, 34, 67] and [90] Maximum Pages = 113.
        // The third combination has the minimum pages assigned to a student which is 113.
        System.out.println(findPages(arr, k));

        int[] brr = {15, 17, 20};
        k = 5;
        // Since there are more students than total books,
        // it's impossible to allocate a book to each student. so -1
        System.out.println(findPages(brr, k));
    }
}