package Greedy;

import java.util.Arrays;

public class MiniArrowsToBurstBalloons {
    // Agar overlap karega to ek hi arrow se kam
    // ho jayega nahi to arrows badhana parega

    // Method 1: Start ko sort kar ke
    /*public static int findMinArrowShots(int[][] points) {
        int n = points.length;

        // start se sort
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;
        int i=0, j=1;
        while(j < n){
            int ce = points[i][1];
            int ns = points[j][0];
            int ne = points[j][1];

            if(ce < ns){ // no overlap
                count++;
                i = j;
                j++;
            }else{ // overlap - jo end chhota wo consider taki wo v fut sake
                if(ce < ne)  j++;
                else{
                    i = j;
                    j++;
                }
            }
        }

        return count;
    }*/

    // Method 1 hi hai but better
    /*public static int findMinArrowShots(int[][] points) {
        int n = points.length;

        // start se sort
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;
        int ltie = points[0][1]; // last taken index ka end
        for(int i=1; i<n; i++){
            if(ltie < points[i][0]) { // ce < ns (no overlap)
                count++;
                ltie = points[i][1];
            }else{ // overlap - min wala end
                ltie = Math.min(ltie, points[i][1]);
            }
        }

        return count;
    }*/

    // Method 2: end ko sort kar ke
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;

        // end se sort
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int ltie = points[0][1]; // last taken index ka end
        for(int i=1; i<n; i++) {
            if (ltie < points[i][0]) { // ce < ns (no overlap)
                count++;
                ltie = points[i][1];
            }

            // since end k base pe sortd hai so ltie me always smaller
            // hi rahega so kuchh karne ka no need
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] points1 = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        System.out.println(findMinArrowShots(points1));
        // Expected: 2

        int[][] points2 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        System.out.println(findMinArrowShots(points2));
        // Expected: 4

        int[][] points3 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        System.out.println(findMinArrowShots(points3));
        // Expected: 2

        int[][] points4 = {
                {1, 10},
                {2, 9},
                {3, 8},
                {4, 7}
        };
        System.out.println(findMinArrowShots(points4));
        // Expected: 1
    }
}