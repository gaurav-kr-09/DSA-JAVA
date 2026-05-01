package Recursion;

import java.util.Scanner;

public class ReverseOfNo {
    //Without recursion.
//    public static int reverse(int n){
//        int res = 0;
//        while(n > 0){
//            res = res*10 + (n%10);
//            n /= 10;
//        }
//        return res;
//    }

    //With recursion
    public static int reverse(int originalNo, int reverseNo){
        if(originalNo == 0) return reverseNo;

        return reverse(originalNo/10, reverseNo*10+originalNo%10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int originalNumber = sc.nextInt();

        System.out.println(reverse(originalNumber, 0)); // Pahla no. to wo jisko reverse karna hai and dusra answer store karne k liiye.
    }
}
