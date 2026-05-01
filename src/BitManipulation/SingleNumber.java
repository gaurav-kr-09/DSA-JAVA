package BitManipulation;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int xor = 0; // 0 xor X = X
        for(int n: nums) xor ^= n;
        return xor;
    }

    // SAME As
    /*public static int singleNumber(int[] nums) {
        for(int i=1; i < nums.length; i++) nums[0] ^= nums[i];
        return nums[0];
    }*/

    public static void main(String[] args) {
        int[] nums = {4,5,4,1,2,1,2};
        System.out.println("Single no. in array is: " + singleNumber(nums));
    }
}
