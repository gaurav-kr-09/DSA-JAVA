package Graphs.KruskalAlgo;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    private static class Edge {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    private static List<Edge> ans;

    private static int[] parent;
    private static int[] size;
    private static int findMst(int n, List<Edge> edges ){
        // Step 1: Initialize parent and size
        ans = new ArrayList<>();

        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        // Step 2: sort the edges array
        edges.sort((a, b) -> Integer.compare(a.wt, b.wt));
        
        // Step 3: apply the kruskal algo
        int mstWeight = 0;
        int edgesInMst = 0;
        for (Edge curr: edges) {
            int u = curr.u;
            int v = curr.v;
            
            if(findLeader(u) != findLeader(v)){
                union(u, v);

                mstWeight += curr.wt;
                edgesInMst++;

                ans.add(curr);
            }

            if(edgesInMst == n-1) break;
        }
        return mstWeight;
    }

    private static void union(int a, int b){
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
    
    private static int findLeader(int a){
        if(parent[a] == a) return a;
        return parent[a] = findLeader(parent[a]);
    }

    public static void main(String[] args) {
        int V = 7;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 2, 9));
        edges.add(new Edge(0, 6, 29));
        edges.add(new Edge(2, 3, 26));
        edges.add(new Edge(3, 1, 24));
        edges.add(new Edge(3, 5, 21));
        edges.add(new Edge(1, 5, 19));
        edges.add(new Edge(1, 6, 14));
        edges.add(new Edge(6, 4, 15));
        edges.add(new Edge(5, 4, 11));

        System.out.println("Original edges");
        for (Edge edge : edges) {
            System.out.println( edge.u + " -> " + edge.v + " : " + edge.wt);
        }

        int mstWeight = findMst(V, edges);
        System.out.println("Mst graph is: ");
        for (Edge t : ans) {
            System.out.println( t.u + " -> " + t.v + " : " + t.wt);
        }

        System.out.println("Mst weight is: " + mstWeight);
    }
}
