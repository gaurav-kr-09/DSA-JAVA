package Methods;

import java.util.Scanner;

public class SwapTwoNos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.println("Before Swap: ");
        System.out.println(a + " , " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After Swap: ");
        System.out.println(a + " , " + b);
    }
}
