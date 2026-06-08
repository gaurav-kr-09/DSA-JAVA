package Graphs;

import java.util.*;

public class CourseSchedule2 {
    public static ArrayList<Integer> ans; // only for dfs
    public static int[] findOrder(int numCourses, int[][] pre) {
        int n = pre.length;
        int v = numCourses;

        // Step 1: make adjacency list and indegree array
        List<List<Integer>> adj = new ArrayList<>();
        // int[] indegree = new int[v]; // only for BFS
        for(int i=0; i<v; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            int a = pre[i][0], b = pre[i][1]; // edge b -> a
            adj.get(b).add(a);
            // indegree[a]++; // indegree of a is increased - Only for BFS
        }

        // Step 2: now find cycle

        // METHOD 1: BFS KAHN'S ALGO
        /*int[] ans = new int[v];
        int k = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int front = q.poll();
            ans[k++] = front;

            for(int neigh: adj.get(front)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.offer(neigh);
            }
        }

        // if no cycle then complete else not complete
        return k == v ? ans : new int[]{};*/

        // METHOD 2: DFS
        boolean[] visited = new boolean[v];
        boolean[] recVisited = new boolean[v];
        ans = new ArrayList<>();

        for(int i=0; i<v; i++){
            if(!visited[i]){
                if(detectCycleDFS(i, visited, recVisited, adj)) return new int[]{};
            }
        }

        Collections.reverse(ans);
        int[] res = new int[v];
        for(int i=0; i<v; i++) res[i] = ans.get(i);
        return res;
    }

    private static boolean detectCycleDFS(int start, boolean[] visited, boolean[] recVisited, List<List<Integer>> adj) {
        visited[start] = true;
        recVisited[start] = true;

        for(int neigh: adj.get(start)){
            if(!visited[neigh] && detectCycleDFS(neigh, visited, recVisited, adj)) return true;
            else if(recVisited[neigh]) return true;
        }

        ans.add(start);
        recVisited[start] = false;

        return false;
    }

    public static void main(String[] args) {

        // TC1
        int numCourses1 = 2;
        int[][] prerequisites1 = {
                {1, 0}
        };

        System.out.println("TC1 Expected: [0, 1]");
        System.out.println("TC1 Actual  : " +
                Arrays.toString(findOrder(numCourses1, prerequisites1)));



        // TC2
        int numCourses2 = 4;
        int[][] prerequisites2 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        // Valid answers:
        // [0,1,2,3]
        // [0,2,1,3]

        System.out.println("\nTC2 Expected: Valid Topological Order");
        System.out.println("TC2 Actual  : " +
                Arrays.toString(findOrder(numCourses2, prerequisites2)));



        // TC3
        int numCourses3 = 1;
        int[][] prerequisites3 = {};

        System.out.println("\nTC3 Expected: [0]");
        System.out.println("TC3 Actual  : " +
                Arrays.toString(findOrder(numCourses3, prerequisites3)));



        // TC4 (Cycle)
        int numCourses4 = 2;
        int[][] prerequisites4 = {
                {1, 0},
                {0, 1}
        };

        System.out.println("\nTC4 Expected: []");
        System.out.println("TC4 Actual  : " +
                Arrays.toString(findOrder(numCourses4, prerequisites4)));



        // TC5 (Cycle)
        int numCourses5 = 4;
        int[][] prerequisites5 = {
                {1, 0},
                {2, 1},
                {0, 2},
                {3, 2}
        };

        System.out.println("\nTC5 Expected: []");
        System.out.println("TC5 Actual  : " +
                Arrays.toString(findOrder(numCourses5, prerequisites5)));



        // TC6 (Disconnected DAG)
        int numCourses6 = 6;
        int[][] prerequisites6 = {
                {1, 0},
                {3, 2},
                {5, 4}
        };

        // One valid answer:
        // [0,2,4,1,3,5]

        System.out.println("\nTC6 Expected: Valid Topological Order");
        System.out.println("TC6 Actual  : " +
                Arrays.toString(findOrder(numCourses6, prerequisites6)));
    }
}
