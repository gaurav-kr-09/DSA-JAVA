package Loops;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to check: ");
        int n = sc.nextInt();

        if (n == 0 || n == 1) {
            System.out.println("Neither Prime nor composite");
            return;
        }

        boolean PrimeFlag = true;
//        for(int i = 2; i < (n / 2) + 1; i++){
        for(int i = 2; i <= Math.sqrt(n) + 1; i++){
            if(n % i == 0){
                PrimeFlag = false;
                break;
            }
        }

        if(PrimeFlag) System.out.println("Prime no.");
        else System.out.println("Composite no.");
    }
}
