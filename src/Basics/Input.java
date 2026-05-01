package Basics;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Radius: ");
        double r = sc.nextDouble();
        System.out.println(3.141592 * r * r);
    }
}
