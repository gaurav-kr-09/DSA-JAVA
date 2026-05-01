package BinarySearch;

import java.util.Scanner;

public class singlesInDoubles {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static int findSingle(int[] arr){
        int n = arr.length;
        if(n==1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-2] != arr[n-1]) return arr[n-1];

        int low = 0, high = n -1;

        while(low <= high){
            int mid = low + (high - low) /2;
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) return arr[mid];

            int first = mid, second = mid;
            if (arr[mid] == arr[mid+1]) second = mid + 1;
            else first = mid -1;

            int leftCount = first; // first - low
            int rightCount = n - second; // high - second
            if(leftCount % 2 != 0) high = first-1; //go left
            else low = second+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array (sorted and a/c to qn): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.println(findSingle(arr));
    }
}
