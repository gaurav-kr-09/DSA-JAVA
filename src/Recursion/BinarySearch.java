package Recursion;

public class BinarySearch {
    public static int exists(int[] arr, int target, int start, int end){
        if(start > end) return -1;
        int mid = start + (end - start)/2;

        if(arr[mid] == target) return mid;
        if(arr[mid] > target) return exists(arr, target, start, mid -1);
        else return exists(arr, target, mid+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,13,41,55};
        System.out.println(exists(arr, 22, 0, arr.length-1));
    }
}
