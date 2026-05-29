package QuickSort;

import java.util.Scanner;

public class ThreeWayPartitioningAsDNF {
    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int pivot = arr[start];
        int low=start, mid=start, high= end;
        while(mid <= high){
            // Aage chhota bich me barabar or pivot and last me bada
            if(arr[mid] < pivot){
                swap(arr, low, mid);
                low++;
                mid++;
            }else if(arr[mid] == pivot){
                mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }

        quickSort(arr, start, low-1);
        quickSort(arr, high+1, end);
    }

    // SWAP AS A HELPER FUNCTION
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // DISPLAYING
    private static void display(int[] arr){
        for(int a: arr) System.out.print(a + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter space separated values to sort: ");
        String st = sc.nextLine();

        String[] parts = st.split(" ");
        int[] arr = new int[parts.length];
        for(int i=0; i< parts.length; i++) arr[i] = Integer.parseInt(parts[i]);

        System.out.print("Original array is: ");
        display(arr);

        quickSort(arr, 0, arr.length-1);

        System.out.print("Sorted array is: ");
        display(arr);
    }
}
