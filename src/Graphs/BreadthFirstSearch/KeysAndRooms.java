package Graphs.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    // Method 1: ek hi function me
    /*public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(0);

        while(!q.isEmpty()){
            int front = q.poll();

            for(int key: rooms.get(front)){
                if(!visited[key]){
                    visited[key] = true;
                    q.add(key);
                }
            }
        }

        for(boolean v: visited){
            if(!v) return false;
        }

        return true;
    }*/

    // Method 2: same hi chiz but do function me
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        visited[0] = true;
        BFS(0, rooms, visited);

        for(boolean v: visited){
            if(!v) return false;
        }

        return true;
    }

    public static void BFS(int start, List<List<Integer>> rooms, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int front = q.poll();

            for(int key: rooms.get(front)){
                if(!visited[key]){
                    visited[key] = true;
                    q.add(key);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(
                List.of(1,3),
                List.of(3,0,1),
                List.of(2),
                List.of(0)
        );

        System.out.println(canVisitAllRooms(rooms)); // false

        List<List<Integer>> rooms2 = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );

        System.out.println(canVisitAllRooms(rooms2)); // true
    }
}