package BackTracking;

public class RatInAMaze3RightAllDirections {
    private static int paths(int sr, int sc, int er, int ec, String s, int[][] maze, boolean[][] isVisited){
        if(sr < 0 || sc < 0) return 0;
        if(sr > er || sc > ec) return 0; // bahar chala gaya
        if(sr == er && sc == ec){ // last or destination cell
            System.out.println(s);
            return 1;
        }
        if(maze[sr][sc] == 0) return 0; // cell blocked hai
        if(isVisited[sr][sc]) return 0; // cell already visited

        isVisited[sr][sc] = true; // check for visited
        int downPaths = paths(sr+1, sc, er, ec, s+"D", maze, isVisited);
        int rightPaths = paths(sr, sc+1, er, ec, s+"R", maze, isVisited);
        int leftPaths = paths(sr, sc-1, er, ec, s+"L", maze, isVisited);
        int upPaths = paths(sr-1, sc, er, ec, s+"U", maze, isVisited);
        isVisited[sr][sc] = false; // backtracking

        return downPaths + rightPaths + leftPaths + upPaths;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1,0,1,1},
            {1,1,1,1},
            {1,1,0,1},
        };
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        int path = paths(0, 0, maze.length-1, maze[0].length-1, "", maze, isVisited);
        System.out.println(path);
    }
}