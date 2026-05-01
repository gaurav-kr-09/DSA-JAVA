package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of disks: ");
        int n = sc.nextInt();

        hanoi(n, 'A', 'B', 'C');
    }

    public static void hanoi(int n, char src, char helper, char dest) {
        if(n==0) return;

        //n-1 disks from src to helper via destination.
        hanoi(n-1, src, dest, helper);

        //Largest from source to destination
        System.out.println(src + " -> "+ dest);

        //n-1 disks from helper to destination via src.
        hanoi(n-1, helper, src, dest);
    }
}
