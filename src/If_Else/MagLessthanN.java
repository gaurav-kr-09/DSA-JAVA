package If_Else;

import java.util.Scanner;

public class MagLessthanN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        if(n<0) n = -n;

        if(n <100) System.out.println("Lesser than 100");
        else System.out.println("More than 100");
    }
}
