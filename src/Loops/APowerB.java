package Loops;

import java.util.Scanner;

public class APowerB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base number: ");
        int a = sc.nextInt();
        System.out.print("Enter exponent number: ");
        int b = sc.nextInt();

        int pow = 1;
        for (int i = 1; i <= b; i++) {
            pow *= a;
        }
        System.out.println("result is: " + pow);
    }
}
