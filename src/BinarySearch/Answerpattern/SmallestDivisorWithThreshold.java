package BinarySearch.Answerpattern;

public class SmallestDivisorWithThreshold{
    public static int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = -1;
        for(int num: nums) hi = Math.max(hi, num);

        int ans = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(sumOfCeil(mid, nums) <= threshold){
                // divisor thik-thak hai but
                // kya isse chhota divisor possible hai
                ans = mid;
                hi = mid-1;
            }
            else lo = mid + 1;
        }

        return ans;
    }

    private static int sumOfCeil(int divisor, int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(arr, threshold)); // ans = 5

        int[] brr = {44,22,33,11,1};
        threshold = 5;
        System.out.println(smallestDivisor(brr, threshold)); // ans = 44
    }
}
