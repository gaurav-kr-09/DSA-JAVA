package Strings;

import java.util.Scanner;

public class CountDigitsWithoutLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter integer: ");
        int n = sc.nextInt();

        System.out.println("No. of digits: "+ (""+n).length());
        System.out.println("No. of digits: "+ Integer.toString(n).length());

        double d = 4.15d;
        System.out.println(d + "Gaurav"); //Works same as int

        d = 000.0005800;
        System.out.println((""+d).length()); // -> Isme 6 print hoga 0 point k just pahle wala then point k bad 0, 0, 0, 5, 8 -> total 6

        String str = "754408";
        int m = Integer.parseInt(str);
        System.out.println(m); //754408
        System.out.println(m + 5); // 754413
    }
}
