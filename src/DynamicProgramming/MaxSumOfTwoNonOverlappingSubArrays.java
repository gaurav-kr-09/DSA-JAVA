package DynamicProgramming;

public class MaxSumOfTwoNonOverlappingSubArrays {
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        // SOLVE
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {0,6,5,2,2,5,1,9,4}; int firstLen = 1; int secondLen = 2;
        System.out.println(maxSumTwoNoOverlap(arr, firstLen, secondLen)); // 20

        int[] brr = {3,8,1,3,2,1,8,9,0}; firstLen = 3; secondLen = 2;
        System.out.println(maxSumTwoNoOverlap(brr, firstLen, secondLen)); //29

        int[] crr = {2,1,5,6,0,9,5,0,3,8}; firstLen = 4; secondLen = 3;
        System.out.println(maxSumTwoNoOverlap(crr, firstLen, secondLen));
    }
}