package Graphs.DSU;

import java.util.Arrays;

public class RedundantConnections {
    private static int[] parent;
    private static int[] size;
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<n; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            if(findLeader(a) == findLeader(b)) return new int[]{a,b};
            union(a, b);
        }

        return new int[]{-1, -1};
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

        int[][] edges1 = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        System.out.println(
                Arrays.toString(findRedundantConnection(edges1))
        ); // Expected: [2, 3]


        int[][] edges2 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        };

        System.out.println(
                Arrays.toString(findRedundantConnection(edges2))
        ); // Expected: [1, 4]


        int[][] edges3 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 1}
        };

        System.out.println(
                Arrays.toString(findRedundantConnection(edges3))
        ); // Expected: [5, 1]
    }
}