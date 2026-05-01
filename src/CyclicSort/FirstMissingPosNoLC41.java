package CyclicSort;

import java.util.Scanner;

public class FirstMissingPosNoLC41 {
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
        System.out.println("Enter " + n + " elements in array (a/c to question): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.print("Missing element is: "+ firstMissingPositive(arr));
    }

    private static int firstMissingPositive(int[] arr) {
        int i = 0, n = arr.length;

        while(i < n){
            int index = arr[i] - 1;
            if(arr[i] <= 0 || arr[i] > n || arr[i] == i+1 || arr[i] == arr[index]) i++;
            else{
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        for (i = 0; i < n; i++) {
            if(arr[i] != i+1) return i+1;
        }
        return n+1;
    }
}
