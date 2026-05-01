package If_Else;

import java.util.Scanner;

public class CheckInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        double d = sc.nextDouble();

//        int x = (int)d;
//        if(d-x == 0) System.out.println("Integer");
        if(d == (int)d) System.out.println("Integer");
        else System.out.println("Not an Integer");
    }
}
