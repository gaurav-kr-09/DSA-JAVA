package QuickSort;

import java.util.Random;
import java.util.Scanner;

public class RandomizedLomutoPartition {
    // QUICK SORT FUNCTION
    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int pi = partitionIdx(arr, start, end);

        quickSort(arr, start, pi-1);
        quickSort(arr, pi+1, end);
    }

    // Randomized way
    private static final Random rand = new Random();
    private static int partitionIdx(int[] arr, int start, int end) {
        // choosing the random index as pivot
        int pIdx = rand.nextInt(end-start+1) + start;

        // Sending pivot on last
        swap(arr, pIdx, end);

        // pivot is now at end
        int pivot = arr[end];

        // keping lesser and equal in left and larger in right
        int i=start-1, j=start;
        while(j <= end-1){
            // agar agge wala chhota hai ya barabar hai to usko pichhe bhejo
            if(arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }

        // now position the pivot on right place
        swap(arr, i+1, j);
        // return the pivot index
        return i+1;
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
