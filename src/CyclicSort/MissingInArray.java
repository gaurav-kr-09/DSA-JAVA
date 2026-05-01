package CyclicSort;

import java.util.Scanner;

public class MissingInArray {
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
        System.out.println("Enter " + n + " elements in array (a/c to the question): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.println("The no. missing in the array is: "+missingNum(arr));
    }

    public static int missingNum(int[] arr){
        int n = arr.length + 1;
        int i = 0;
        while(i < arr.length){
            if(arr[i] == i+1 || arr[i] == n) i++;
            else{
                int index = arr[i] - 1;

                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        for(i = 0; i < arr.length; i++){
            if(arr[i] != i+1) return i+1;
        }
        return n;
    }
}
