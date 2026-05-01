package Patterns.SpecialShapes;

import java.util.Scanner;

public class NumTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows: ");
        int n = sc.nextInt();

//        for (int i = 1; i <= n; i++) {
//            int start = 1;
//            for (int j = 1; j <= i; j++) {
//                System.out.print(start +" ");
//                start += 2;
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2*i; j+=2) {
                System.out.print(j +" ");
            }
            System.out.println();
        }

    }
}
