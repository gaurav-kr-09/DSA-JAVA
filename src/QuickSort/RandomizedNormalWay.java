package QuickSort;

import java.util.Random;
import java.util.Scanner;

public class RandomizedNormalWay {
    // QUICK SORT FUNCTION
    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int pi = partitionIdx(arr, start, end);

        quickSort(arr, start, pi-1);
        quickSort(arr, pi+1, end);
    }

    // RANDOMIZED QUICK SORT - USING NORMAL WAY
    private static int partitionIdx(int[] arr, int start, int end) {
        // choosing random pivot b/w start and end
        Random rand = new Random();
        int pidx = rand.nextInt(end-start+1) + start;

        // move pivot to start
        swap(arr, start, pidx);
        int pivot = arr[start];

        // counting elements lesser than equal to pivot for positioning
        int count = 0;
        for(int i = start+1; i <= end; i++){
            if(arr[i] <= pivot) count++;
        }

        // finding pivot index and keep it on right place
        int pivotIndex = start +count;
        swap(arr, start, pivotIndex);

        // keeping smaller and equal elements before pivot and larger after pivot
        int i=start, j=end;
        while(i < pivotIndex && j > pivotIndex){
            while (arr[i] <= arr[pivotIndex]) i++;
            while (arr[j] > arr[pivotIndex]) j--;

            if(i < pivotIndex && j > pivotIndex){
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return pivotIndex;
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
