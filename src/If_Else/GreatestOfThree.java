package If_Else;

import java.util.Scanner;

public class GreatestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int a = sc.nextInt();
        System.out.print("Enter number 2: ");
        int b = sc.nextInt();
        System.out.print("Enter number 3: ");
        int c = sc.nextInt();

//        if(a >= b && a >= c) System.out.println("a is greatest");
//        else if(b >= a && b >= c) System.out.println("b is greatest");
//        else System.out.println("C is greatest");

//        if (a > b){
//            if(a > c){
//                System.out.println("a is greatest");
//            }else{
//                System.out.println("c is greatest");
//            }
//        }else{
//            if(b > c){
//                System.out.println(" b is greatest");
//            }else{
//                System.out.println("c is greatest");
//            }
//        }

        System.out.println((a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c));
    }
}
