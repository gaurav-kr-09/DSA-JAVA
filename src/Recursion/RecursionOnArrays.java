package Recursion;

public class RecursionOnArrays {
    /*public static void recPrint(int[] arr, int firstIdx){
        if(firstIdx == arr.length) return;
        System.out.print(arr[firstIdx] + " ");
        recPrint(arr, firstIdx+1);
    }*/

    public static void recPrintReverseOrder(int[] arr, int idx){
        if(idx == arr.length) return;
        recPrintReverseOrder(arr, idx+1);
        System.out.print(arr[idx] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 9, 8};

        //recPrint(arr, 0);
        recPrintReverseOrder(arr, 0);
    }
}
