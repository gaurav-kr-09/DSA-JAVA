package Recursion;

import java.util.Scanner;

public class GCD {
    public static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();

        /*//Using For Loop
        int min = Math.min(a, b);
        for(int i = min; i >= 1; i--){
            if(a % i == 0 && b % i == 0){
                System.out.println(i);
                break;
            }
        }*/

        System.out.println(gcd(a, b));
    }
}
