package Graphs;

import java.util.*;

public class CheapestFlightsWithKStops {
    private static class Pair{
        int node;
        int price;

        Pair(int node, int price){
            this.node = node;
            this.price = price;
        }
    }

    private static class Triplet{
        int node;
        int cost;
        int stops;

        Triplet(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Make The Adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int i=0; i< flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];

            adj.get(from).add(new Pair(to, price));
        }

        // Apply Dijkstra's algo
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;

        // PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.stops, b.stops));
        // pq.offer(new Triplet(src, 0, 0));

        Queue<Triplet> q = new ArrayDeque<>();
        q.offer(new Triplet(src, 0, 0));

        while (/*!pq.isEmpty()*/ !q.isEmpty()){
            // Triplet top = pq.poll();
            Triplet top = q.poll();
            int node = top.node, cost = top.cost, stops = top.stops;

            if(stops == k+1) continue;

            for(Pair neigh: adj.get(node)){
                int newCost = neigh.price + cost;
                if(newCost < ans[neigh.node]){
                    ans[neigh.node] = newCost;
                    // pq.add(new Triplet(neigh.node, newCost, stops+1));
                    q.add(new Triplet(neigh.node, newCost, stops+1));
                }
            }
        }

        return ans[dst] == Integer.MAX_VALUE ? -1 : ans[dst];
    }

    public static void main(String[] args) {

        // Test Case 1
        int n1 = 4;

        int[][] flights1 = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };

        int src1 = 0;
        int dst1 = 3;
        int k1 = 1;

        System.out.println(
                findCheapestPrice(n1, flights1, src1, dst1, k1)
        );
        // Expected: 700


        // Test Case 2
        int n2 = 3;

        int[][] flights2 = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        int src2 = 0;
        int dst2 = 2;
        int k2 = 1;

        System.out.println(
                findCheapestPrice(n2, flights2, src2, dst2, k2)
        );
        // Expected: 200


        // Test Case 3
        int n3 = 3;

        int[][] flights3 = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        int src3 = 0;
        int dst3 = 2;
        int k3 = 0;

        System.out.println(
                findCheapestPrice(n3, flights3, src3, dst3, k3)
        );
        // Expected: 500
    }
}
