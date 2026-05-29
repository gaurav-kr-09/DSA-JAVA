package QuickSort;

import java.util.Scanner;

public class HoaresPartition {
    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int pi = partitionIdx(arr, start, end);

        quickSort(arr, start, pi); // NOT pi-1-> coz Hoare doesn’t place pivot finally.
        quickSort(arr, pi+1, end);
    }

    // USING NORMAL WAY
    private static int partitionIdx(int[] arr, int start, int end) {
        // Choosing the first element as pivot
        int pivot = arr[start];

        // smaller in left side and larger in right side
        // My way
        // int i=start, j=end;
        // while(true){
        //     while (arr[i] < pivot) i++;
        //     while (arr[j] > pivot) j--;
        //
        //     if(i >= j) return j;
        //
        //     swap(arr, i, j);
        //     i++; j--;
        // }

        // isme ant me xtra i++ and j-- kana pada
        // isiliye TEXTBOOK SOLUTION

        int i=start-1, j=end+1;
        while(true){
            do i++;
            while (arr[i] < pivot);

            do j--;
            while (arr[j] > pivot);

            if(i >= j) return j;

            swap(arr, i, j);
        }
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
