package DNFForReminder;

public class SortArrayByParity2 {
    public static int[] sortArrayByParityII(int[] nums){
        int n = nums.length;
        int i=0, j=1;
        while (i < n && j < n){
            while(i < n && nums[i] % 2 == 0) i+=2;
            while(j < n && nums[j] % 2 != 0) j+=2;

            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,5,7};
        int[] ans = sortArrayByParityII(arr);
        for(int n: arr) System.out.print(n + " ");
    }
}