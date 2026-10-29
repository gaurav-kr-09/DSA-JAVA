package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    // Method 1: start ko sort karna
    /*public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> ans = new ArrayList<>();
        int i=0, j=1;
        int cs = intervals[0][0];
        while(j < n){
            int ce = intervals[i][1];
            int ns = intervals[j][0];
            int ne = intervals[j][1];

            if(ce < ns){ // no overlap
                ans.add(new int[]{cs, ce});
                i = j;
                j++;
                cs = intervals[i][0];
            }else{ // overlap -> bada wala consider
                if(ce > ne) j++;
                else{
                    i = j;
                    j++;
                }
            }
        }

        // ek jo last wala bach jayega wo add
        int maxEnd = Math.max(intervals[i][1], intervals[j-1][1]);
        ans.add(new int[]{cs, maxEnd});

        int al = ans.size(); // length of ans
        int[][] res = new int[al][2];
        for(int k = 0; k < al; k++) res[k] = ans.get(k);

        return res;
    }*/

    // Method 1 ka better version
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> ans = new ArrayList<>();
        int sli = intervals[0][0]; // start of latest interval
        int eli = intervals[0][1]; // end of latest interval
        for(int i=1; i<n; i++){
            int cs = intervals[i][0];
            int ce = intervals[i][1];

            if(cs <= eli){ // overlap
                eli = Math.max(eli, ce);
            }else{ // no overlap
                ans.add(new int[]{sli, eli});
                sli = cs;
                eli = ce;
            }
        }

        // last ka bacha hua
        ans.add(new int[]{sli, eli});

        int al = ans.size(); // length of ans
        int[][] res = new int[al][2];
        for(int k = 0; k < al; k++) res[k] = ans.get(k);

        return res;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(merge(intervals1)));
        // Expected: [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = {
                {1, 4},
                {4, 5}
        };
        System.out.println(Arrays.deepToString(merge(intervals2)));
        // Expected: [[1, 5]]

        int[][] intervals3 = {
                {4, 7},
                {1, 4}
        };
        System.out.println(Arrays.deepToString(merge(intervals3)));
        // Expected: [[1, 7]]

        int[][] intervals4 = {
                {1, 4},
                {0, 2},
                {3, 5}
        };
        System.out.println(Arrays.deepToString(merge(intervals4)));
        // Expected: [[0, 5]]
    }
}