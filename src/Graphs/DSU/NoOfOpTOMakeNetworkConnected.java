package Graphs.DSU;

public class NoOfOpTOMakeNetworkConnected {
    public static int[] parent;
    public static int[] size;
    public static int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges < n-1) return -1;

        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<edges; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            union(u, v);
        }

        int components = 0; // will kee
        for(int i=0; i<n; i++){
            if(parent[i] == i) components++;
        }
        return components-1;
    }

    public static void union(int a, int b){
        a = findLeader(a);
        b = findLeader(b);

        if(a == b) return;

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
        int n1 = 4;

        int[][] connections1 = {
                {0, 1},
                {0, 2},
                {1, 2}
        };

        System.out.println(
                makeConnected(n1, connections1)
        ); // Expected: 1


        int n2 = 6;

        int[][] connections2 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        System.out.println(
                makeConnected(n2, connections2)
        ); // Expected: 2


        int n3 = 6;

        int[][] connections3 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2}
        };

        System.out.println(
                makeConnected(n3, connections3)
        ); // Expected: -1


        int n4 = 5;

        int[][] connections4 = {
                {0, 1},
                {0, 2},
                {3, 4},
                {2, 3}
        };

        System.out.println(
                makeConnected(n4, connections4)
        ); // Expected: 0
    }
}
