package Graphs.Dijkstra;

import java.util.*;

public class DijkstraUsingQueue {
    // ACTUALLY THIS IS NOT "Dijkstra Using Queue"
    //Ye actually SPFA-style relaxation hai.

    private static class Pair{
        int node;
        int cost;

        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    private static int[] dijkstra(List<List<Pair>> adj){
        int n = adj.size();

        // Step 1: make a answer array and fill it with inf and 0 for source
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        // Step 2: make the q and add source
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));

        // Step 3: Apply simple BFS using queue
        while (!q.isEmpty()){
            Pair front = q.poll();

            if(front.cost > ans[front.node]) continue;

            for(Pair neigh: adj.get(front.node)){
                int newCost = front.cost + neigh.cost;
                if(newCost < ans[neigh.node]){
                    ans[neigh.node] = newCost;
                    q.add(new Pair(neigh.node, newCost));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Pair>> adj = new ArrayList<>();
        // graph 1 -> 5 node ka - 0 is the source
        for(int i=0; i<5; i++) adj.add(new ArrayList<>());

        // 0th node
        adj.get(0).add(new Pair(1,30));
        adj.get(0).add(new Pair(4,5));
        adj.get(0).add(new Pair(3,20));

        // 1st node
        adj.get(1).add(new Pair(0,30));
        adj.get(1).add(new Pair(2,4));

        // 2nd node
        adj.get(2).add(new Pair(1,4));
        adj.get(2).add(new Pair(3,7));
        adj.get(2).add(new Pair(4,8));

        // 3rd node
        adj.get(3).add(new Pair(0,20));
        adj.get(3).add(new Pair(2,7));
        adj.get(3).add(new Pair(4,6));

        // 4th node
        adj.get(4).add(new Pair(0,5));
        adj.get(4).add(new Pair(2,8));
        adj.get(4).add(new Pair(3,6));

        int[] ans = dijkstra(adj);

        for(int i: ans) System.out.print(i + " ");
    }
}