package BackTracking;

public class RatInAMaze3RightAllDirectionsFullyOptimized {
    private static int paths(int sr, int sc, int er, int ec, StringBuilder sb, int[][] maze){
        if(sr < 0 || sc < 0 || sr > er || sc > ec) return 0; // bahar chala gaya
        if(maze[sr][sc] == 0 || maze[sr][sc] == -1) return 0;
        if(sr == er && sc == ec){ // last or destination cell
            System.out.println(sb);
            return 1;
        }

        maze[sr][sc] = -1;
        int downPaths = paths(sr+1, sc, er, ec, sb.append("D"), maze);
        sb.deleteCharAt(sb.length()-1);
        int rightPaths = paths(sr, sc+1, er, ec, sb.append("R"), maze);
        sb.deleteCharAt(sb.length()-1);
        int leftPaths = paths(sr, sc-1, er, ec, sb.append("L"), maze);
        sb.deleteCharAt(sb.length()-1);
        int upPaths = paths(sr-1, sc, er, ec, sb.append("U"), maze);
        sb.deleteCharAt(sb.length()-1);
        maze[sr][sc] = 1; // backtracking

        return downPaths + rightPaths + leftPaths + upPaths;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1,0,1,1},
            {1,1,1,1},
            {1,1,0,1},
        };
        StringBuilder sb = new StringBuilder();
        int path = paths(0, 0, maze.length-1, maze[0].length-1, sb, maze);
        System.out.println(path);
    }
}