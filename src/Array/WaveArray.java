package Array;

import java.util.Scanner;

public class WaveArray {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements (sorted) in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

//        for(int i =0; i < n-1; i++){
//            if(i % 2 == 0){
//                int temp = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = temp;
//            }
//        }

        for(int i =0; i < n-1; i+=2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

        System.out.println("Wavy array: ");
        display(arr, n);
    }
}
