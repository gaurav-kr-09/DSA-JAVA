package Array.MissingQns;

public class PrevPermutationWithOneSwap {
    public static int[] prevPermOpt1(int[] arr) {
        int i = arr.length-2;
        while(i >= 0 && arr[i] <= arr[i+1]) i--;
        if(i >= 0){
            int j=arr.length-1;
            // rightmost element smaller than arr[i]
            while(arr[j] >= arr[i]) j--;
            // agar duplicate pe hai j to left most pe jao
            while(j >= 0 && arr[j] == arr[j-1]) j--;
            // swap
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3}; // 1 2 3
        int[] brr = {3,2,1}; // 3 1 2
        int[] crr = {3,1,2,4,5}; // 2 1 3 4 5
        display(prevPermOpt1(arr));
        display(prevPermOpt1(brr));
        display(prevPermOpt1(crr));
    }

    public static void display(int[] arr){
        for(int n: arr) System.out.print(n + " ");
        System.out.println();
    }
}
