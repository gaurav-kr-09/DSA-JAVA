package BackTracking;

import java.util.Scanner;

public class UniquePaths {
    // Without backtracking - two vars
    /*private static int paths(int rows, int cols){
        if(rows == 1 || cols == 1) return 1;
        return paths(rows-1, cols) + paths(rows, cols-1);
    }*/

    // Without backtracking - four vars
    private static int paths(int sr, int sc, int er, int ec){
        if(sr > er || sc > ec) return 0;
        if(sr == er || sc == ec) return 1;

        int downWays = paths(sr+1, sc, er, ec);
        int rightWays = paths(sr, sc+1, er, ec);
        return downWays + rightWays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter cols: ");
        int cols = sc.nextInt();

        // System.out.println("No. of ways: "+ paths(rows, cols));

        System.out.println("No. of ways: "+ paths(0, 0, rows-1, cols-1));
    }
}