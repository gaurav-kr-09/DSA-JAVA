package DynamicProgramming;

public class PartitionEqualsSubsetSum {
    // RECURSION ka ye v kam karega but not smart
    /*public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;

        return partition(0, nums, 0, sum);
    }

    public static boolean partition(int i, int[] arr, int cSum, int tSum){
        if(cSum == tSum) return true;
        if(i >= arr.length) return false;

        boolean pick = partition(i+1, arr, cSum + arr[i], tSum-arr[i]);
        boolean skip = partition(i+1, arr, cSum, tSum);

        return pick || skip;
    }*/

    // DURA RECURSION - agar Subset sum me target ko sum ka half kar de tab itna dimag lagane ka jarurat hi nahi prega
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;

        if(sum%2 != 0) return false;
        int target = sum / 2;
        return isSumTar(0, nums, target);
    }

    // AND SO On same SUBSET SUM PROBLEM wala scene

    private static boolean isSumTar(int i, int[] nums, int target) {
        if(target == 0) return true;
        if(i >= nums.length || target < 0) return false;

        boolean pick = isSumTar(i+1, nums, target-nums[i]);
        boolean skip = isSumTar(i+1, nums, target);

        return pick || skip;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        System.out.println(canPartition(nums1)); // Expected: true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(canPartition(nums2)); // Expected: false

        int[] nums3 = {2, 2, 1, 1};
        System.out.println(canPartition(nums3)); // Expected: true

        int[] nums4 = {1, 1};
        System.out.println(canPartition(nums4)); // Expected: true

        int[] nums5 = {1};
        System.out.println(canPartition(nums5)); // Expected: false

        int[] nums6 = {3, 3, 3, 4, 5};
        System.out.println(canPartition(nums6)); // Expected: true
    }
}