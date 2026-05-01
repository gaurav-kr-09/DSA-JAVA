package Recursion;

import java.util.Scanner;

public class Fibonacci {
    public static int nthFib(int n){
        if(n == 1) return 0;
        if(n == 2) return 1;
        return nthFib(n-1)+nthFib(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println(nthFib(n));
    }
}
