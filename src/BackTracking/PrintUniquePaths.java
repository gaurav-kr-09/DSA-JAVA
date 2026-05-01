package BackTracking;

import java.util.Scanner;

public class PrintUniquePaths {
    // Without backtracking - four vars
    private static void paths(int sr, int sc, int er, int ec, String s){
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        paths(sr, sc+1, er, ec, s+"R"); // go right
        paths(sr+1, sc, er, ec, s+"D"); // go down
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter cols: ");
        int cols = sc.nextInt();

        System.out.println("Paths are: ");
        paths(1, 1, rows, cols, "");
    }
}