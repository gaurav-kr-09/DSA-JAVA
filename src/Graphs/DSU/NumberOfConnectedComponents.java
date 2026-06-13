package Graphs.DSU;

public class NumberOfConnectedComponents {
    // Method 1: simple DSU and path compression
    /*private static int[] parent;
    public static int countComponents(int n, int[][] edges) {
        // Make parent array and make everyone their own parent
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        // Take union of edges
        for(int i=0; i<edges.length; i++){
            union(edges[i][0], edges[i][1]);
        }

        // finding no. of components
        int components = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) components++;
        }

        return components;
    }

    public static void union(int a, int b){
        int leaderA = findLeader(a);
        int leaderB = findLeader(b);

        if(leaderA == leaderB) return; // cycle forming edge
        parent[leaderB] = leaderA; // making a parent of b in (a,b)
    }

    public static int findLeader(int node){
        if(parent[node] == node) return node;
        // return findLeader(parent[node]); // basic DSU
        return parent[node] = findLeader(parent[node]); // path compression
    }*/

    // Method 2: Union by size
    /*private static int[] parent;
    private static int[] size;
    public static int countComponents(int n, int[][] edges) {
        // Make parent array - and everyone their self parent and size 1
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        // Take union of edges
        for(int i=0; i<edges.length; i++){
            union(edges[i][0], edges[i][1]);
        }

        // finding no. of components
        int components = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) components++;
        }

        return components;
    }

    public static void union(int a, int b){
        int leaderA = findLeader(a);
        int leaderB = findLeader(b);

        if(leaderA == leaderB) return; // cycle forming edge
        if(size[leaderA] > size[leaderB]) { // a should be parent of b
            parent[leaderB] = leaderA;
            size[leaderA] += size[leaderB];
        } else{
            parent[leaderA] = leaderB; // b should be parent of a
            size[leaderB] += size[leaderA];
        }
    }

    public static int findLeader(int node){
        if(parent[node] == node) return node;
        // return findLeader(parent[node]); // basic DSU
        return parent[node] = findLeader(parent[node]); // path compression
    }*/

    // Method 3: Union by rank
    private static int[] parent;
    private static int[] rank;
    public static int countComponents(int n, int[][] edges) {
        // Make parent array - and everyone their self parent and rank 1
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0; // 0 already filled but for more redablity
        }

        // Take union of edges
        for(int i=0; i<edges.length; i++){
            union(edges[i][0], edges[i][1]);
        }

        // finding no. of components
        int components = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) components++;
        }

        return components;
    }

    public static void union(int a, int b){
        int leaderA = findLeader(a);
        int leaderB = findLeader(b);

        if(leaderA == leaderB) return;
        if(rank[leaderA] > rank[leaderB]) // a should be parent of b
            parent[leaderB] = leaderA;
        else if(rank[leaderB] > rank[leaderA])
            parent[leaderA] = leaderB;
        else{
            parent[leaderA] = leaderB; // random parent
            rank[leaderB]++; // jo parent bana uska rank++
        }
    }

    public static int findLeader(int node){
        if(parent[node] == node) return node;
        // return findLeader(parent[node]); // basic DSU
        return parent[node] = findLeader(parent[node]); // path compression
    }

    public static void main(String[] args) {

        int n = 7;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int ans = countComponents(n, edges);

        System.out.println(ans); // Expected: 3
    }
}