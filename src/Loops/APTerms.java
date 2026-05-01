package Loops;

import java.util.Scanner;

public class APTerms  {
    public static void main(String[] args) {
        // 2, 5, 8, 11, ......
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms u want: ");
        int n = sc.nextInt();

//        for (int i = 1; i <= n; i++) {
//            int term = 2 + ((i - 1) * 3);
//            System.out.print(term + "\t");
//        }

//        int tn = 2 + ((n - 1) * 3);
//
//        for (int i = 2; i <= tn; i += 3) {
//            System.out.print(i + "\t");
//        }

        int a = 2, d = 3;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + "\t");
            a += d;
        }

        System.out.println();

        // 99, 95, 91, 87, 83, .......
        int f = 99, cd = -4;
        for (int i = 1; i <= n; i++) {
            if(f < 0) break;
            System.out.print(f + "\t");
            f += cd;
        }

    }
}
