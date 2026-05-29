package Array.DutchNationalFlag;

public class SortColors {
    // METHOD 1 -> O(N) but not best two pass
    /*public static void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;
        for(int num: nums){
            if(num == 0) zeros++;
            else if(num == 1) ones++;
            else twos++;
        }

        for(int i =0; i<zeros; i++) nums[i] = 0;
        for(int i=0; i<ones; i++) nums[i+zeros] = 1;
        for(int i =0; i<twos; i++) nums[i+ones+zeros] = 2;
    }*/

    // METHOD 2 -> O(N) Single pass DUTCH NATIONAL FLAG ALGORITHM
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        for(int n: arr) System.out.print(n + " ");
    }
}
