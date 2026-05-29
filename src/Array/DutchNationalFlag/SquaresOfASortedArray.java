package Array.DutchNationalFlag;

public class SquaresOfASortedArray {
    // METHOD 1: O(NLogN)
    /*public static int[] sortedSquares(int[] nums) {
        int n = nums.length;

        for(int i= 0; i <n; i++){
            nums[i] = nums[i]*nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }*/

    // METHOD 2; OPTIMAL O(N)
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int k = n-1;
        int i = 0, j = n-1;
        while (i <= j){
            int iSq = nums[i] * nums[i];
            int jSq = nums[j] * nums[j];
            if(iSq > jSq){
                ans[k] = iSq;
                i++;
            }else{
                ans[k] = jSq;
                j--;
            }
            k--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        int[] ans = sortedSquares(arr);
        for(int n: ans) System.out.print(n + " ");
    }
}
