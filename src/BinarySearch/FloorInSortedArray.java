package BinarySearch;

import java.util.Scanner;

public class FloorInSortedArray {
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
        System.out.println("Enter " + n + " elements in array (sorted order): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.print("Enter The target to find floor: ");
        int target = sc.nextInt();

        int index = -1;
        int low = 0, high = n -1;
        while(low <= high){
            int mid = low + (high - low) /2;
            if(arr[mid] > target){
                high = mid - 1;
            }else{
                index = mid;
                low = mid + 1;
            }
        }

        System.out.println(index);
    }
}
