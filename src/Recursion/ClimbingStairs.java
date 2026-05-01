package Recursion;

import java.util.Scanner;

public class ClimbingStairs {
    //If max step is 2
    public static int ways(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return ways(n-1)+ways(n-2);
    }

    /*//If max step is 3
    public static int ways(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        return ways(n-1)+ways(n-2)+ways(n-3);
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of steps: ");
        int n = sc.nextInt();

        System.out.println(ways(n));
    }
}
