package Loops;

import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter +ve number: ");
        int n = sc.nextInt();

        System.out.print(1 + "\t");

        for(int i = 2; i <= Math.sqrt(n) + 1; i++){
            if(n % i == 0){
                System.out.print((n / i == i) ? i + "\t" : i + "\t" + n/i + "\t");
            }
        }

        System.out.print(n);
    }
}
