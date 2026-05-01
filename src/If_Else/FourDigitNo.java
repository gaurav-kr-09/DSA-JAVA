package If_Else;

import java.util.Scanner;

public class FourDigitNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();

        if(n > 999 && n < 10000){
            System.out.println("4 digit no.");
        }else{
            System.out.println("Not a four digit no.");
        }
    }
}
