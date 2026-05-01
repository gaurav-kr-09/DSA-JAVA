package Patterns.SpecialShapes;

import java.util.Scanner;

public class StarPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows: ");
        int a = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                if(i == ((a / 2) + 1) || j == ((a / 2) + 1)) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
