package Graphs.DSU;

public class IsGraphBipartite {
    private static int[] parent;
    private static int[] size;

    // Method 1: Without parity
    /*public static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int node = 0; node < n; node++){
            if(graph[node].length == 0) continue;

            int nodeLeader = findLeader(node);
            // checking if first neighbour is in different set from node
            if(nodeLeader == findLeader(graph[node][0])) return false;

            for(int i=1; i < graph[node].length; i++){
                // node and uska neighbour alag-alag set me hona chahiye
                if(nodeLeader == findLeader(graph[node][i]))
                    return false;
                // put neighbours in a single set
                union(graph[node][i-1], graph[node][i]);
            }
        }

        return true;
    }

    // union for method 1
    private static void union(int a, int b){
        a = findLeader(a);
        b = findLeader(b);

        if(size[a] >= size[b]){
            parent[b] = a;
            size[a] += size[b];
        }else{
            parent[a] = b;
            size[b] += size[a];
        }
    }*/

    // Method 2: With Parity
    private static boolean[] parity;
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        parent = new int[n];
        size = new int[n];
        parity = new boolean[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
            parity[i] = false; // not needed but for readibility
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < graph[i].length; j++){
                int node = i, neigh = graph[i][j];

                if(neigh > node){ // to avoid redundancy
                    if(findLeader(node) == findLeader(neigh)){ // cycle detected
                        // check parity, if different then ok else false
                        if(parity[node] == parity[neigh]) return false;
                    }

                    else union(node, neigh);
                }
            }
        }

        return true;
    }

    // union for method 2
    private static void union(int a, int b){
        int la = findLeader(a);
        int lb = findLeader(b);

        if(size[la] >= size[lb]){
            parent[lb] = la;
            size[la] += size[lb];
            parity[b] = !parity[a]; // chhota wala child banega so change it's parity
        }else{
            parent[la] = lb;
            size[lb] += size[la];
            parity[a] = !parity[b]; // // chhota wala child banega so change it's parity
        }
    }

    private static int findLeader(int a){
        if(parent[a] == a) return a;
        return parent[a] = findLeader(parent[a]);
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[][] graph1 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        System.out.println(isBipartite(graph1)); // false

        // Sample Test Case 2
        int[][] graph2 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        System.out.println(isBipartite(graph2)); // true

        // Sample Test Case 3
        int[][] graph3 = {
                {},
                {}
        };
        System.out.println(isBipartite(graph3)); // true

        // Sample Test Case 4
        int[][] graph4 = {
                {1},
                {0, 2},
                {1}
        };
        System.out.println(isBipartite(graph4)); // true
    }
}
