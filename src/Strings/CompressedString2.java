package Strings;

import java.util.Scanner;

public class CompressedString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The String length: ");
        int n = sc.nextInt();
        char[] chars = new char[n];

        System.out.println("Enter string elements: ");
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
        }

        System.out.println("Original string array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(chars[i] + "\t");
        }
        System.out.println();

        int read = 0, write = 0;

        while (read < n) {
            char current = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            chars[write] = current;
            write++;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        System.out.println("Resulting compressed array: ");
        for (int i = 0; i < write; i++) {
            System.out.print(chars[i] + "\t");
        }
        System.out.println("\nCompressed length: " + write);
        sc.close();
    }
}
