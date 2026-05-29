package BinarySearch.Answerpattern;

public class PaintersPartitionProblem {
    private static int minTime(int[] arr, int k) {
        int lo = 0, hi = 0;
        for(int a: arr){
            lo = Math.max(lo, a);
            hi += a;
        }

        int ans = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(isPossible(arr, mid, k)){
                // if time mid allows us to paint
                // with k painters or fewer
                ans = mid;
                hi = mid-1;
            }
            else lo = mid + 1;
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int maxAllowedTime, int painters){
        int p = 1;
        int currTime = 0;

        for(int len: arr){
            if(len > maxAllowedTime) return false;

            if(currTime + len <= maxAllowedTime) currTime += len;
            else {
                p++;
                currTime = len;
            }
        }

        return p <= painters;
    }

    public static void main(String[] args) {
        // Given an array arr[] and an integer k, where the array represents
        // the boards and each element denotes the length of a board,
        // and k painters are available to paint these boards.
        // Each unit length of a board takes 1 unit of time to paint.
        // Find the minimum time required to paint all the boards such that
        // each painter paints only contiguous sections of the array.
        // A painter can paint boards like [2, 3, 4], [1], or even no board,
        // but cannot paint non-contiguous boards like [2, 4, 5].

        int[] arr = {5, 10, 30, 20, 15};
        int k = 3;

        // The most optimal way will be:Painter 1 allocation :
        // [5,10], Painter 2 allocation : [30],
        // Painter 3 allocation : [20, 15],
        // Job will be done when all painters finish i.e.
        // at time = max(5 + 10, 30, 20 + 15) = 35

        System.out.println(minTime(arr, k));

        int[] brr = {10, 20, 30, 40};
        int k2 = 2;

        // The most optimal way to paint:
        // Painter 1 allocation : [10, 20, 30],
        // Painter 2 allocation : [40],
        // Job will be complete at time = 60

        System.out.println(minTime(brr, k2));
    }
}
