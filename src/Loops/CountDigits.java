package Loops;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter +ve number: ");
        int n = sc.nextInt();

        int count  = 0;
        if(n == 0) count = 1;
        else {
            while(n != 0){ // n > 0 v likh sakte hai but negative k case me fail ho jayega
                n = n / 10;
                count++;
            }
        }

        System.out.println("No. of Digits: "+ count);
    }
}
