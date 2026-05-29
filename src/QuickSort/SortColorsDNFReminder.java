package QuickSort;

public class SortColorsDNFReminder {
    public static void sortColors(int[] nums) {
        int low=0, mid=0, high= nums.length-1;

        while (mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
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
