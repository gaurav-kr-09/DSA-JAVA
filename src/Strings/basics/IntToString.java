package Strings;

import java.util.Scanner;

public class IntToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //simplest - ek empty string bana k integer jor do to wo pura integer string me convert ho jayega.
        String s = "";
        s += n;
        System.out.println(s);
        System.out.println(s + 85);

        String t = Integer.toString(n);
        System.out.println(t);
    }
}
