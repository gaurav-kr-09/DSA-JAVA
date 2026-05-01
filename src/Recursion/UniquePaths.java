package Recursion;

import java.util.Scanner;

public class UniquePaths {
    // Default recursion - will be optimised using DP

    // Method 1 - direct solving
    /*public static int paths(int rows, int cols){
        if(rows == 1 || cols == 1) return 1; // Agar ek row ya column to ek hi tarika sidha hi jana parega.
        return paths(rows-1, cols) + paths(rows, cols-1);
    }*/

    //Method 2 - maintaining 4 variables.
    /*public static int pathsSecond(int cr, int cc, int lr, int lc) {
        if(cr == lr && cc == lc) return 1;
        if(cr>lr || cc <lc) return 0;

        int down = pathsSecond(cr+1, cc, lr, lc);
        int right = pathsSecond(cr, cc+1, lr, lc);
        return right + down;
    }*/

    //Method 3 -similar to method 3 what if we go from last cell to first cell so we will get work done in only 2 variables.
    public static int pathThird(int cr, int cc) {
        if(cr == 1 && cc == 1) return 1;
        if(cr == 0 || cc == 0) return 0;

        int up = pathThird(cr-1, cc);
        int left = pathThird(cr, cc-1);
        return up + left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter cols: ");
        int cols = sc.nextInt();

        //System.out.println("No. of ways: "+ paths(rows, cols)); //Method - 1

        //System.out.println("No. of ways: "+ pathsSecond(0, 0, rows-1, cols-1)); //Method - 2

        System.out.println("No. of ways: "+ pathThird(rows, cols)); //Method - 3
    }
}
