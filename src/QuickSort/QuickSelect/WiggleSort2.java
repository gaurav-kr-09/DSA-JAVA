package QuickSort.QuickSelect;

import java.util.Arrays;

public class WiggleSort2 {
    // METHOD 1: EXTRA SPACE AND NogN by sorting
    // https://www.youtube.com/watch?v=-0J6ONtAhoA
    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] temp = new int[n];

        int i=1, j=n-1;
        while (i<n){
            temp[i] = nums[j];
            i+=2;
            j--;
        }

        i=0;
        while (i<n){
            temp[i] = nums[j];
            i+=2;
            j--;
        }

        for(int k=0; k<n; k++) nums[k] = temp[k];
    }

    // ISKA OPTIMAL O(N) WALA BAD ME

    public static void main(String[] args) {
        int[] arr = {1,5,1,1,6,4};
        wiggleSort(arr);
        for(int a: arr) System.out.print(a + " ");

        System.out.println();

        int[] brr = {1,3,2,2,3,1};
        wiggleSort(arr);
        for(int a: brr) System.out.print(a + " ");
    }
}