package BackTracking;

public class RatInAMaze3RightAndDown {
    private static int paths(int sr, int sc, int er, int ec, String s, int[][] maze){
        if(sr > er || sc > ec) return 0; // bahar chala gaya
        if(sr == er && sc == ec){ // last or destination cell
            System.out.println(s);
            return 1;
        }

        if(maze[sr][sc] == 0) return 0; // cell blocked hai

       int downPaths = paths(sr+1, sc, er, ec, s+"D", maze);
       int rightPaths = paths(sr, sc+1, er, ec, s+"R", maze);

       return downPaths+rightPaths;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1,0,1,1,1,1},
            {1,1,1,1,0,1},
            {0,1,1,1,1,1},
            {0,0,1,0,1,1},
        };

        int path = paths(0, 0, maze.length-1, maze[0].length-1, "", maze);
        System.out.println(path);
    }
}