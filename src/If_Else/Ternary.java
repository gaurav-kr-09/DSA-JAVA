package If_Else;

import java.util.Scanner;

public class Ternary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        System.out.println((n % 2 == 0)? "Even": "Odd");

        int g = (n >= 0) ? 100 : 0;
        System.out.println(g);
    }
}
