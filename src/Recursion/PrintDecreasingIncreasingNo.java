package Recursion;
//To print like 5 4 3 2 1 1 2 3 4 5
import java.util.Scanner;

public class PrintDecreasingIncreasingNo {
    public static void print(int n){
//        if(n == 1){
//            System.out.print(n+ " ");
//        }
//        if(n==1) return;  // agar n ek hi bar chahiye ho to ye v kar sakte hai

        if(n == 0) return;
        System.out.print(n + " ");
        print(n-1);
        System.out.print(n + " ");

//        if(n != 1) System.out.print(n + " "); //Agar 1 hi bar print karna chahte hai to

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        print(n);
    }
}
