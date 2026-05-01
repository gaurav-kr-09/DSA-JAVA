package BinarySearch;

import java.util.Scanner;

public class MaxOfPositiveNdNegative {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static int findResult(int[] arr){
        int low = 0, high = arr.length -1;
        int firstPos = -1;
        int lastNeg = -1;

        // first +ve occurrence
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] < 1){
                low = mid + 1;
            }else{
                firstPos = mid;
                high = mid -1;
            }
        }

        low = 0;
        high = arr.length -1;

        // last -ve occurrence
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > -1){
                high = mid -1;
            }else{
                lastNeg = mid;
                low = mid + 1;
            }
        }

        int neg = lastNeg + 1;
        int pos = (firstPos == -1) ? 0 : arr.length - firstPos;
        return Math.max(neg, pos);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array Sorted Order: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.println("Result is: ");
        System.out.println(findResult(arr));
    }
}
