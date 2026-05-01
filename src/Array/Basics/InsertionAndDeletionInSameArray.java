package Array.Basics;

import java.util.Scanner;

public class InsertionAndDeletionInSameArray {
    public static void display(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static int[] insertion(int[] arr, int index, int val){
        int n = arr.length;
        if(index < 0 || index > n){
            System.out.println("Invalid insertion index");
            return arr;
        }

        int[] newArr = new int[n+1];

        for(int i = 0; i < index; i++){
            newArr[i] = arr[i];
        }

        newArr[index] = val;

        for(int i = index; i < n; i++){
            newArr[i+1] = arr[i];
        }

        return newArr;
    }

    public static int[] deletion(int[] arr, int index){
        int n = arr.length;
        if(index < 0 || index >= n){
            System.out.println("Invalid deletion index");
            return arr;
        }

        for(int i = index; i < n-1; i++){
            arr[i] = arr[i+1];
        }

        int[] newArr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
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
        display(arr);

        arr = insertion(arr,2, 75);
        System.out.println("Inserted Array: ");
        display(arr);

        arr = deletion(arr,2);
        System.out.println("Deleted Array: ");
        display(arr);
    }
}
