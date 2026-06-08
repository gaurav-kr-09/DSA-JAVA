package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule1 {
    public static boolean canFinish(int numCourses, int[][] pre) {
        int n = pre.length;
        int v = numCourses;

        // Step 1: make adjacency list and indegree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[v];
        for(int i=0; i<v; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            int a = pre[i][0], b = pre[i][1]; // edge b -> a
            adj.get(b).add(a);
            indegree[a]++; // indegree of a is increased
        }

        // Step 2: now find cycle

        // METHOD 1: BFS KAHN'S ALGO
        /*List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int front = q.poll();
            ans.add(front);

            for(int neigh: adj.get(front)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.offer(neigh);
            }
        }

        return ans.size() == v;*/

        // METHOD 2: DFS
        boolean[] visited = new boolean[v];
        boolean[] recVisited = new boolean[v];

        for(int i=0; i<v; i++){
            if(!visited[i]){
                if(detectCycleDFS(i, visited, recVisited, adj)) return false;
            }
        }

        // if no cycle then complete else not complete
        return true;
    }

    private static boolean detectCycleDFS(int start, boolean[] visited, boolean[] recVisited, List<List<Integer>> adj) {
        visited[start] = true;
        recVisited[start] = true;

        for(int neigh: adj.get(start)){
            if(!visited[neigh] && detectCycleDFS(neigh, visited, recVisited, adj)) return true;
            else if(recVisited[neigh]) return true;
        }

        recVisited[start] = false;
        return false;
    }

    public static void main(String[] args) {

        // TC1
        int numCourses1 = 2;
        int[][] prerequisites1 = {
                {1, 0}
        };

        System.out.println("TC1 Expected: true");
        System.out.println("TC1 Actual  : " +
                canFinish(numCourses1, prerequisites1));


        // TC2
        int numCourses2 = 2;
        int[][] prerequisites2 = {
                {1, 0},
                {0, 1}
        };

        System.out.println("\nTC2 Expected: false");
        System.out.println("TC2 Actual  : " +
                canFinish(numCourses2, prerequisites2));


        // TC3
        int numCourses3 = 4;
        int[][] prerequisites3 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        System.out.println("\nTC3 Expected: true");
        System.out.println("TC3 Actual  : " +
                canFinish(numCourses3, prerequisites3));


        // TC4
        int numCourses4 = 4;
        int[][] prerequisites4 = {
                {1, 0},
                {2, 1},
                {0, 2}
        };

        System.out.println("\nTC4 Expected: false");
        System.out.println("TC4 Actual  : " +
                canFinish(numCourses4, prerequisites4));


        // TC5
        int numCourses5 = 5;
        int[][] prerequisites5 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {4, 3}
        };

        System.out.println("\nTC5 Expected: true");
        System.out.println("TC5 Actual  : " +
                canFinish(numCourses5, prerequisites5));
    }
}