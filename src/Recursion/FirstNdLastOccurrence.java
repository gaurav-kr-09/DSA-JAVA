package Recursion;

public class FirstNdLastOccurrence {
    public static int firstOcc(int[] arr, int tar, int low, int high, int fo){
        if(low>high) return fo;
        int mid = low+(high-low)/2;
        if(tar > arr[mid]) return firstOcc(arr, tar, mid+1, high, fo);
        else if(tar < arr[mid]) return firstOcc(arr, tar, low, mid-1, fo);
        else{
            return firstOcc(arr, tar, low, mid-1, mid);
        }
    }

    public static int lastOcc(int[] arr, int tar, int low, int high, int lo){
        if(low>high) return lo;
        int mid = low+(high-low)/2;
        if(tar > arr[mid]) return lastOcc(arr, tar, mid+1, high, lo);
        else if(tar < arr[mid]) return lastOcc(arr, tar, low, mid-1, lo);
        else{
            return lastOcc(arr, tar, mid+1, high, mid);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2, 3, 3, 3, 3, 3, 5, 9, 15, 15, 26};

        System.out.println("First occurrence: "+ firstOcc(arr, 15, 0, arr.length-1, -1));
        System.out.println("Last occurrence: "+ lastOcc(arr, 15, 0, arr.length-1, -1));
    }
}
