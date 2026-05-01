package Loops;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        /*//Till n terms
        int first = 0, second = 1;
        if(n == 1){
            System.out.print(first+ " ");
        }else{
            System.out.print(first+ " ");
            System.out.print(second+ " ");
            for(int i = 2; i < n; i++) {
                int res = first + second;
                System.out.print(res + " ");
                first = second;
                second = res;
            }
        }*/

        //nth fibonacci
        int first = 0, second = 1;
        if(n == 1){
            System.out.print(first);
        }else{
            int res = 0;
            for(int i = 2; i < n; i++) {
                res = first + second;
                first = second;
                second = res;
            }
            System.out.println(res);
        }
    }
}
