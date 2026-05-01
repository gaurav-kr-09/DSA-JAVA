package Patterns.SpecialShapes;

import java.util.Scanner;

public class LeftStarNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows: ");
        int n = sc.nextInt();

//        Method 1
        /*for (int i = 1; i <= n; i++) {
            int start = 1;

            for (int j = 1; j <= (n-i); j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(start + " ");
                start++;
            }
            System.out.println();
        }*/

//        Method 2
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= (n-i); j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

//        For A BB CCC ....
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= (n-i); j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print((char)(i+64) + " ");
            }
            System.out.println();
        }
    }
}
