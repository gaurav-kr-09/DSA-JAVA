package Array.MissingQns;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int k = 1;
        for(int i=1; i< nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(arr);

        for(int i=0; i<k; i++){
            System.out.print(arr[i] + " ");
        }
    }
}