package Array.DutchNationalFlag;

public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {
        int i=0, j=nums.length-1;
        while(i < j){
            if(nums[i] % 2 == 0) i++;
            else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int[] ans = sortArrayByParity(arr);
        for(int n: arr) System.out.print(n + " ");
    }
}