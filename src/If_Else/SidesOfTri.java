package If_Else;

import java.util.Scanner;

public class SidesOfTri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int a = sc.nextInt();
        System.out.print("Enter number 2: ");
        int b = sc.nextInt();
        System.out.print("Enter number 3: ");
        int c = sc.nextInt();

        if(a+b > c && a+c >b && b+c>a){
            System.out.println("May be sides of a triangle");
        }else{
            System.out.println("Invalid triangle");
        }
    }
}
