package Array;

import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

//        int max = arr[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }

        System.out.println("Maximum Element is: "+ max);
    }
}
