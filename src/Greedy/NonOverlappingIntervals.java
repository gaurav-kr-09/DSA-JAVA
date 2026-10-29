package Greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {
    // Method 1: start se sort
    /*public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int i=0, j=1;
        while(j < n){
            int ce = intervals[i][1];

            int ns = intervals[j][0];
            int ne = intervals[j][1];

            if(ce <= ns){ // no overlap
                i = j;
                j++;
            }else{ // overlap
                if(ce > ne){ // curr delete
                    i = j;
                    j++;
                    count++;
                }else{ // next delete
                    j++;
                    count++;
                }
            }
        }

        return count;
    }*/

    // Method 1 ko hi thora sa better bana sakte hai, single pointer
    /*public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int lie = intervals[0][1]; // last retained interval's end
        for(int i=1; i<n; i++){
            if(intervals[i][0] < lie){ // (overlap) same as ns < ce
                count++;
                // jo pahle khatam hua usko rakh liye and bad me khatam hone wala delete
                // ex -> [1,10] and [2,5] me [1,10] wala delete
                lie = Math.min(lie, intervals[i][1]);
            }
            else lie = intervals[i][1]; // no overlap
        }

        return count;
    }*/

    // Method 2: last wala sort
    /*public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int i=0, j=1;
        while(j < n){
            int ce = intervals[i][1];
            int ns = intervals[j][0];

            if(ce > ns){ // overlap & next delete
                count++;
                j++;
            }else{ // no deletion
                i = j;
                j++;
            }
        }

        return count;
    }*/

    // Method 2 ko hi thora sa better bana sakte hai, single pointer
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lie = intervals[0][1]; // last retained interval's end
        for(int i=1; i<n; i++){
            // overlap & next delete - lie ko change karne ka no need
            // kyuki aage wale ka hi end chhota hai
            if (intervals[i][0] < lie) count++;
            else lie = intervals[i][1]; // no deletion required
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        System.out.println(eraseOverlapIntervals(intervals1));
        // Expected: 1

        int[][] intervals2 = {
                {1, 2},
                {1, 2},
                {1, 2}
        };
        System.out.println(eraseOverlapIntervals(intervals2));
        // Expected: 2

        int[][] intervals3 = {
                {1, 2},
                {2, 3}
        };
        System.out.println(eraseOverlapIntervals(intervals3));
        // Expected: 0

        int[][] intervals4 = {
                {1, 4},
                {2, 3},
                {3, 5},
                {4, 6}
        };
        System.out.println(eraseOverlapIntervals(intervals4));
        // Expected: 2
    }
}