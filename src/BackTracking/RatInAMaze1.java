package BackTracking;

import java.util.Scanner;

public class RatInAMaze1 {
    private static void paths(int sr, int sc, int er, int ec, String s, boolean[][] isVisited){
        if(sr < 0 || sc < 0) return;
        if(sr > er || sc > ec) return;
        if(isVisited[sr][sc]) return;
        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        isVisited[sr][sc] = true;
        paths(sr, sc+1, er, ec, s+"R", isVisited); // go right
        paths(sr+1, sc, er, ec, s+"D", isVisited); // go down
        paths(sr, sc-1, er, ec, s+"L", isVisited); // go left
        paths(sr-1, sc, er, ec, s+"U", isVisited); // go up

        // backtrack
        isVisited[sr][sc] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter cols: ");
        int cols = sc.nextInt();

        boolean[][] isVisited = new boolean[rows][cols];

        System.out.println("Paths are: ");
        paths(0, 0, rows-1, cols-1, "", isVisited);
    }
}
