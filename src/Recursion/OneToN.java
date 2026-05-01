package Recursion;

/*public class OneToN {
    public static void print(int x, int n){
        if(x > n) return;
        System.out.println(x);
        print(x+1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        print(1, n);
    }
}*/

/*public class OneToN { //Using global variable
    static int x = 1;
    public static void print(int n){
        if(x > n) return;
        System.out.println(x);
        x++;
        print(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        print(n);
    }
}*/

/*public class OneToN { //Using global variable 2
    static int n;
    public static void print(int x){
        if(x > n) return;
        System.out.println(x);
        print(x+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        n = sc.nextInt();

        print(1);
    }
}*/

import java.util.Scanner;

public class OneToN {
    public static void print(int n){
        if(n == 0) return;
        print(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        print(n);
    }
}