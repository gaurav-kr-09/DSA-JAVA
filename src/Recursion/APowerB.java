package Recursion;

import java.util.Scanner;

public class APowerB {
//    public static int power(int a, int b){
//        if(b == 0) return 1;
//        return a * power(a, b-1);
//    }

    public static int power(int a, int b){
        if(b == 0) return 1;

        int temp = power(a, b/2);
        if(b%2 == 0) return temp*temp;
        else return a*temp*temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter expo: ");
        int expo = sc.nextInt();

        System.out.println(power(base, expo));
    }
}
