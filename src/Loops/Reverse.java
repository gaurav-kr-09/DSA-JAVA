package Loops;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter +ve number: ");
        int n = sc.nextInt();

        int rev = 0;
        while(n != 0){
//            int ld = n % 10;
//            rev *= 10;
//            rev+=ld;
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        System.out.println(rev);
    }
}
