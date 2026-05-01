package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    // Method 1: using comparator
    /*private static int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            // (a,b) -> Integer.compare((b[0]*b[0] + b[1]*b[1]), (a[0]*a[0] + a[1]*a[1])) // iski jagah ye v kar sakte hai
            (a,b) -> (b[0]*b[0] + b[1]*b[1]) -  (a[0]*a[0] + a[1]*a[1]) // but upar wala better tha
        );

        for(int[] point: points){
            pq.add(point);
            if(pq.size() > k) pq.poll();
        }

        int i = 0;
        while (!pq.isEmpty()){
            ans[i++] = pq.poll();
        }

        return ans;
    }*/

    // Method 2: using comparator optimized distance bar bar calculate nahi hoga
    /*private static int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(b[2], a[2])
        );

        for(int[] point: points){
            int p0 = point[0];
            int p1 = point[1];
            int distSq = (p0*p0 + p1*p1);  // (0 - p0)sq + (0 - p1) sq = p0sq + p1 ssq
            pq.add(new int[]{p0, p1, distSq});

            if(pq.size() > k) pq.poll();
        }

        int i = 0;
        while (!pq.isEmpty()){
            int[] top = pq.poll();
            ans[i++] = new int[]{top[0], top[1]};
        }

        return ans;
    }*/

    // Method 3: similar but by making xtra class
    static class Triplet implements Comparable<Triplet>{
        int x;
        int y;
        int dist;
        Triplet(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = x * x + y * y;
        }

        public int compareTo(Triplet t){
            return Integer.compare(this.dist, t.dist);
        }
    }

    private static int[][] kClosest(int[][] points, int k){
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] point: points){
            pq.add(new Triplet(point[0], point[1]));

            if(pq.size() > k) pq.poll();
        }

        int[][] ans = new int[k][2];
        int i = 0;
        for(Triplet ele: pq){
            ans[i++] = new int[]{ele.x, ele.y};
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2; // ans -> [[-2,4],[3,3]]
        int[][] ans = kClosest(points, k);
        System.out.print("K closest points to origin are: ");
        for(int[] arr: ans){
            System.out.print("[");
            System.out.print(arr[0] + "," + arr[1]);
            System.out.print("],");
        }
    }
}