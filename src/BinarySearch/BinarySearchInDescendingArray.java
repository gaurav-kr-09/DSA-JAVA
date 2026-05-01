package BinarySearch;

import java.util.Scanner;

public class BinarySearchInDescendingArray {
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
        System.out.println("Enter " + n + " elements in array (sorted order - descending)");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.print("Enter The target to find: ");
        int target = sc.nextInt();

        boolean found = false;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (high+low)/2; // for optimizing we should use mid = low + (high - low)/ 2
            if(arr[mid] == target){
                System.out.println(target + " Found at "+ mid + " index.");
                found = true;
                break;
            } else if (target > arr[mid]) {
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        if(!found) System.out.println(target + " not found in array.");
    }
}
