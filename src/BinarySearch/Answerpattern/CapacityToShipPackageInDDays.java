package BinarySearch.Answerpattern;

public class CapacityToShipPackageInDDays {
    public static int shipWithinDays(int[] weights, int days) {
        // Step 1: find the search space i.e (max value to sum of all values)
        int max = Integer.MIN_VALUE, sum = 0;
        for(int w: weights){
            max = Math.max(max, w);
            sum += w;
        }

        // Step 2: defining the search space and finding optimal solution
        int ans = max; // in worst case
        int lo = max, hi = sum;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(daysWithMid(mid, weights) <= days){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid + 1;
        }

        return ans;
    }

    // function to return no. of days required with current capacity
    private static int daysWithMid(int capacity, int[] weights) {
        int days = 0;
        int c = capacity;

        for(int w: weights){
            if(c >= w) c -= w;
            else{
                days ++;
                c = capacity - w; // subtracting current weight from capacity
            }
        }

        days++; // last wale k liye jisme capacity se kam ya barabar weight hoga
        return days;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        // A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
        // 1st day: 1, 2, 3, 4, 5
        // 2nd day: 6, 7
        // 3rd day: 8
        // 4th day: 9
        // 5th day: 10

        System.out.println("Min Capacity to ship within d days are: " + shipWithinDays(weights, days));
    }
}