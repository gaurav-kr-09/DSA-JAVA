package BasicSorting;

import java.util.Scanner;

public class SelectionSort {
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
        System.out.println("Enter " + n + " elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

//        Method 1
        /*for(int i = 0; i < n-1; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = i; j < n; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }

            arr[minIndex] = arr[i];
            arr[i] = min;
        }*/

//        Method 2 optimized
        for(int i = 0; i < n-1; i++){
            int minIndex = i;
            for(int j = i; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Sorted Array: ");
        display(arr, n);
    }
}
