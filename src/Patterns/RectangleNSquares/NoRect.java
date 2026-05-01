package Patterns.RectangleNSquares;

import java.util.Scanner;

public class NoRect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows: ");
        int a = sc.nextInt();
        System.out.print("Enter no. of columns: ");
        int b = sc.nextInt();

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print((j+1) + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
