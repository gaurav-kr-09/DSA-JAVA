package Graphs.KruskalAlgo;

import java.util.ArrayList;
import java.util.List;

public class MinCostToConnectAllPoints {
    private static class Edge {
        int u;
        int v;
        int dist;

        Edge(int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
    }

    private static int[] parent;
    private static int[] size;
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Step 1: initialize parents array and size array
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        // Method 1:
        /*// Step 2 : make a list of edges to sort it use minHeap - TC (O(NSqLogN))
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        // Step 3: fill heap by connecting all points initially
        for(int u = 0; u <n; u++){
            int x1 = points[u][0], y1 = points[u][1];
            for (int v = u + 1; v < n; v++) {
                int x2 = points[v][0], y2 = points[v][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                pq.offer(new Edge(u, v, dist));
            }
        }

        // Step 4: Apply Kruskal Algo
        int cost = 0;
        while (!pq.isEmpty()){
            Edge top = pq.poll();
            int u = top.u;
            int v = top.v;
            int dist = top.dist;

            if(findLeader(u) != findLeader(v)){
                cost += dist;
                union(u, v);
            }
        }*/

        // Method 2:
        // Step 2 : make a list of edges and sort it
        List<Edge> edges = new ArrayList<>();

        // Step 3: fill list by connecting all points initially
        for(int u = 0; u <n; u++){
            int x1 = points[u][0], y1 = points[u][1];
            for (int v = u + 1; v < n; v++) {
                int x2 = points[v][0], y2 = points[v][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new Edge(u, v, dist));
            }
        }

        // Step 4: apply Kruskal's algo
        int cost = 0;
        edges.sort((a, b) -> Integer.compare(a.dist, b.dist));
        for(int i=0; i<edges.size(); i++){
            Edge curr = edges.get(i);
            int u = curr.u;
            int v = curr.v;
            int dist = curr.dist;

            if(findLeader(u) != findLeader(v)){
                cost += dist;
                union(u, v);
            }
        }

        return cost;
    }

    public static void union(int a, int b){
        a = findLeader(a);
        b = findLeader(b);

        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
        }else{
            parent[a] = b;
            size[b] += size[a];
        }
    }

    public static int findLeader(int a){
        if(a == parent[a]) return a;
        return parent[a] = findLeader(parent[a]);
    }

    public static void main(String[] args) {

        int[][] points1 = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        int[][] points2 = {
                {3, 12},
                {-2, 5},
                {-4, 1}
        };

        int[][] points3 = {
                {0, 0}
        };

        System.out.println("Test Case 1:");
        System.out.println(minCostConnectPoints(points1)); // Expected: 20

        System.out.println("Test Case 2:");
        System.out.println(minCostConnectPoints(points2)); // Expected: 18

        System.out.println("Test Case 3:");
        System.out.println(minCostConnectPoints(points3)); // Expected: 0
    }
}