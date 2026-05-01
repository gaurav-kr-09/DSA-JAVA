package Methods;

import java.util.Scanner;

public class PermutationsNCombinations {
    public static int factorial(int n){
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int ncr(int n, int r){
        int nf = factorial(n);
        int  rf = factorial(r);
        int nMr = factorial(n-r);

        return nf/(rf* nMr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter r: ");
        int r = sc.nextInt();

        System.out.println(n + "C" + r + ": " + ncr(n, r));

        int npr = factorial(n)/factorial(n-r);
        System.out.println(n + "P" + r + ": " + npr);
    }
}
