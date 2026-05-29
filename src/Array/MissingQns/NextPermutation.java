package Array.MissingQns;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int i=nums.length - 2;
        // First unsorted element from back
        while(i >= 0 && nums[i] >= nums[i+1]) i--;

        if(i >= 0){ // perform swap with just largest element
            int j = nums.length-1;
            while(nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }

        reverse(nums, i+1); // reverse to get the correct permutation
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void reverse(int[] arr, int start){
        int i=start, j=arr.length-1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3}; // 1 3 2
        int[] brr = {3,2,1}; // 1 2 3
        int[] crr = {2,5,4,3,1}; // 3 1 2 4 5
        nextPermutation(arr);
        nextPermutation(brr);
        nextPermutation(crr);
        display(arr);
        display(brr);
        display(crr);
    }

    public static void display(int[] arr){
        for(int n: arr) System.out.print(n + " ");
        System.out.println();
    }
}
