package Graphs.DSU;

public class NumberOfProvinces {
    // Method 1: simple DSU and path compression
    /*private static int[] parent;
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // Make parent array - and everyone their self parent
        parent = new int[n+1]; // since 1 based indexing
        for(int i=0; i<=n; i++) parent[i] = i;

        // Taking union from edges matrix
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j || isConnected[i][j] == 0) continue;
                union(i+1, j+1); // 1 - based indexing
            }
        }

        // Find no of components
        int components = 0;
        for(int i=1; i<=n; i++){
            if(parent[i] == i) components++;
        }
        return components;
    }

    public static void union(int a, int b){
        int leaderA = findLeader(a);
        int leaderB = findLeader(b);

        if(leaderA == leaderB) return; // cycle forming edges
        // Let's make a parent of b in (a, b)
        parent[leaderB] = leaderA;
    }

    public static int findLeader(int node){
        if(parent[node] == node) return node;
        // return findLeader(parent[node]); // basic DSU
        return parent[node] = findLeader(parent[node]); // Path compression
    }*/

    // Method 2: Union by size
    /*private static int[] parent;
    private static int[] size;
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // Make parent array - and everyone their self parent and size 1
        parent = new int[n+1]; // since 1 based indexing
        size = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        // Taking union from edges matrix
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j || isConnected[i][j] == 0) continue;
                union(i+1, j+1); // 1 - based indexing
            }
        }

        // Find no of components
        int components = 0;
        for(int i=1; i<=n; i++){
            if(parent[i] == i) components++;
        }
        return components;
    }

    public static void union(int a, int b){
        int leaderA = findLeader(a);
        int leaderB = findLeader(b);

        if(leaderA == leaderB) return;
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
        return parent[node] = findLeader(parent[node]); // Path compression
    }*/

    // Method 3: Union by rank
    private static int[] parent;
    private static int[] rank;
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // Make parent array - and everyone their self parent and size 1
        parent = new int[n+1]; // since 1 based indexing
        rank = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
            rank[i] = 0; // 0 already filled but for more redablity
        }

        // Taking union from edges matrix
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j || isConnected[i][j] == 0) continue;
                union(i+1, j+1); // 1 - based indexing
            }
        }

        // Find no of components
        int components = 0;
        for(int i=1; i<=n; i++){
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
        return parent[node] = findLeader(parent[node]); // Path compression
    }

    public static void main(String[] args) {

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int ans = findCircleNum(isConnected);

        System.out.println(ans); // Expected: 2
    }
}
