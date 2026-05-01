package Loops;

import java.util.Scanner;

public class SpSeq1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms u want: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(i + "\t");
            System.out.print(n - i + 1 + "\t");
        }
    }
}
