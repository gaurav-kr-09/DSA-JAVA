package Patterns.RectangleNSquares;

import java.util.Scanner;

public class RepeatAlphaSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows: ");
        int a = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                System.out.print((char)(i+64) + " ");
            }
            System.out.println();
        }
    }
}
