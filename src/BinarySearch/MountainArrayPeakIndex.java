package BinarySearch;

import java.util.Scanner;

public class MountainArrayPeakIndex {
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
        System.out.println("Enter " + n + " elements in array (Mountain order): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

//        Method 1
        /*int low = 0, high = n - 1;
        boolean found = false;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid + 1] < arr[mid] && arr[mid - 1] < arr[mid]) {
                System.out.println(arr[mid]);
                found = true;
                break;
            } else if (arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else { //arr[mid + 1] < arr[mid]
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }*/

//        Method 2 (similar to method 1)
        /*int low = 1, high = n -2;
        boolean found = false;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > arr[mid -1] && arr[mid] < arr[mid + 1]) low = mid + 1;
            else if(arr[mid] < arr[mid -1] && arr[mid] > arr[mid + 1]) high = mid - 1;
            else{
                System.out.println(arr[mid]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }*/

//        Method 3
        int low = 0, high = n-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > arr[mid + 1]) high = mid;
            else low = mid + 1;
        }

        System.out.println(arr[low]);

    }
}
