package Patterns;

import java.util.Scanner;

public class SpecialPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array elements separated by single space: ");
        String st = sc.nextLine();
        String[] parts = st.split(" ");
        int n = parts.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }
        System.out.print("The entered no is: ");
        for(int i: arr) System.out.print(i + " ");
        System.out.println();

        //Find the max value
        int max = Integer.MIN_VALUE;
        for(int num: arr) max = Math.max(num, max);

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[j] > i) System.out.print(" * ");
                else System.out.print("   ");
            }
            System.out.println();
        }
    }
}