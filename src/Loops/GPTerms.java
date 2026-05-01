package Loops;

import java.util.Scanner;

public class GPTerms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms u want: ");
        int n = sc.nextInt();

        // 1,2, 4, 8, 16 ......

        int a = 1, r = 2;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + "\t");
            a *= r;
        }
    }
}
