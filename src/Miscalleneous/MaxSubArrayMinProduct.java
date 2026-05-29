package Miscalleneous;

public class MaxSubArrayMinProduct {
    // BRUTEFORCE
    public static int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        // SOLVE
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2}; // ANS 14
        System.out.println(maxSumMinProduct(arr));

        int[] brr = {2,3,3,1,2}; // ANS 18
        System.out.println(maxSumMinProduct(brr));

        int[] crr = {3,1,5,6,4,2}; // ANS 60
        System.out.println(maxSumMinProduct(crr));
    }
}