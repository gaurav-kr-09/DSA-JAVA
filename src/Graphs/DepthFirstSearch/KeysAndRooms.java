package Graphs.DepthFirstSearch;

import java.util.List;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        DFS(0, rooms, visited);

        for(boolean v: visited){
            if(!v) return false;
        }

        return true;
    }

    public static void DFS(int start, List<List<Integer>> rooms, boolean[] visited){
        visited[start] = true;
        for(int i: rooms.get(start)){
            if(!visited[i]) DFS(i, rooms, visited);
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