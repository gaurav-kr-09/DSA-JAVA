package Graphs.Dijkstra;

import java.util.*;

public class DijkstraStoringPaths {
    private static class Pair{
        int node;
        int cost;

        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    private static int[][] dijkstra(List<List<Pair>> adj){
        int n = adj.size();

        // Step 1: make a answer array and fill it with inf and 0 for source
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        // Step 2: Make a parent Array to keep track of parent of each node
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i; // start me sab apna pana parent hai

        // Step 3: make the min heap and add source
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Pair(0, 0));

        // Step 4: Apply simple BFS but using minheap
        while (!pq.isEmpty()){
            Pair front = pq.poll();

            if(front.cost > ans[front.node]) continue;

            for(Pair neigh: adj.get(front.node)){
                int newCost = front.cost + neigh.cost;
                if(newCost < ans[neigh.node]){
                    ans[neigh.node] = newCost;
                    parent[neigh.node] = front.node;
                    pq.add(new Pair(neigh.node, newCost));
                }
            }
        }

        return new int[][]{ans, parent};
    }

    private static List<Integer> getPath(int dest, int[] parent){
        List<Integer> path = new ArrayList<>();

        int node = dest;
        while (parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(node);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList<>();
        // graph 1 -> 5 node ka - 0 is the source
        int n = 5;
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // 0th node
        adj.get(0).add(new Pair(1, 30));
        adj.get(0).add(new Pair(4, 5));
        adj.get(0).add(new Pair(3, 20));

        // 1st node
        adj.get(1).add(new Pair(0, 30));
        adj.get(1).add(new Pair(2, 4));

        // 2nd node
        adj.get(2).add(new Pair(1, 4));
        adj.get(2).add(new Pair(3, 7));
        adj.get(2).add(new Pair(4, 8));

        // 3rd node
        adj.get(3).add(new Pair(0, 20));
        adj.get(3).add(new Pair(2, 7));
        adj.get(3).add(new Pair(4, 6));

        // 4th node
        adj.get(4).add(new Pair(0, 5));
        adj.get(4).add(new Pair(2, 8));
        adj.get(4).add(new Pair(3, 6));

        int[][] res = dijkstra(adj);

        // Printing the shortest distances
        int[] ans = res[0];
        System.out.println("Shortest distances");
        for (int i =0; i<n; i++) System.out.println(i + " -> " + ans[i]);

        // Printing the paths
        int[] parent = res[1];
        System.out.println("Shortest paths");
        for(int i=0; i<n; i++){
            System.out.println(i + " -> " + getPath(i, parent));
        }
    }
}