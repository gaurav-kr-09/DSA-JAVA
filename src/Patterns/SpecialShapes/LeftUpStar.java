package Patterns.SpecialShapes;

import java.util.Scanner;

public class LeftUpStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows: ");
        int n = sc.nextInt();

//        Method 1
        /*for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(j < i) System.out.print("  ");
                else System.out.print("* ");
            }
            System.out.println();
        } */

//        Method 2
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= (n-i+1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
