package Graphs;

import java.util.*;

public class NetworkDelayTime {
    private static class Pair{
        int node;
        int time;

        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Make adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>()); // since 1 to n so n+1

        for(int i=0; i<times.length; i++){
            int src = times[i][0], dest = times[i][1], time = times[i][2];
            adj.get(src).add(new Pair(dest, time));
        }

        // Step 2: make an answer array and fill it with INF and 0 for k i.e source
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;

        // Step 3: Make the min heap and add source
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.offer(new Pair(k, 0));

        // Step 4: Apply Dijkstra algo
        while (!pq.isEmpty()){
            Pair front = pq.poll();

            if(front.time > ans[front.node]) continue;

            for(Pair neigh: adj.get(front.node)){
                int newTime = front.time + neigh.time;
                if(newTime < ans[neigh.node]){
                    ans[neigh.node] = newTime;
                    pq.add(new Pair(neigh.node, newTime));
                }
            }
        }

        // Step 5: find the largest among all transmission times
        int minTime = -1;
        for(int i=1; i<=n; i++){
            if(ans[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, ans[i]);
        }

        return minTime;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[][] times1 = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n1 = 4;
        int k1 = 2;

        System.out.println(networkDelayTime(times1, n1, k1));
        // Expected: 2

        // Test Case 2
        int[][] times2 = {
                {1, 2, 1}
        };
        int n2 = 2;
        int k2 = 1;

        System.out.println(networkDelayTime(times2, n2, k2));
        // Expected: 1

        // Test Case 3
        int[][] times3 = {
                {1, 2, 1}
        };
        int n3 = 2;
        int k3 = 2;

        System.out.println(networkDelayTime(times3, n3, k3));
        // Expected: -1
    }
}