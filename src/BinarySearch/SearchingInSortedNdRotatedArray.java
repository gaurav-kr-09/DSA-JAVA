package BinarySearch;

import java.util.Scanner;

public class SearchingInSortedNdRotatedArray {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static int findMaxIndex(int[] arr){
        int n = arr.length;
        if(n == 1) return 0;
        if(n == 2){
            if(arr[0] > arr[1]) return 0;
            else return 1;
        }

        int low = 0, high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(mid < high && arr[mid] > arr[mid + 1]) return mid;
            if(arr[mid] > arr[0]) low = mid + 1;
            else high = mid -1;
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int firstIndex, int lastIndex, int taregt){
        int low = firstIndex;
        int high = lastIndex;

        while(low <= high){
            int mid = low + (high - low) /2;

            if(arr[mid] == taregt) return mid;
            if(arr[mid] > taregt) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array (Rotated order): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.print("Enter The target to find: ");
        int target = sc.nextInt();

//        Method - 1 using binary search on both sides
        /*int peak = findMaxIndex(arr);
        System.out.println("The peak Index is: "+ peak);

//        now using binary search in both sides
        int left = binarySearch(arr, 0, peak, target);
        int right = binarySearch(arr, peak+1, n-1, target);

        if(left == -1 && right == -1) System.out.println("Not found");
        else System.out.println(Math.max(left, right));*/

//        Method - 2 using binary search directly

        int low = 0, high = n -1, result = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                result = mid;
                break;
            }

            //If left is sorted
            if(arr[low] <= arr[mid]) {
                if(target >= arr[low] && target < arr[mid]) high = mid - 1;
                else low = mid + 1;
            }else{ //Right part is sorted
                if(target > arr[mid] && target <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
        }

        System.out.println(target + " Found at "+ result + " index.");
    }
}
