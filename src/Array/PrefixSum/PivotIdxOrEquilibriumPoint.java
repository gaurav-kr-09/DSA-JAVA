package Array.PrefixSum;

public class PivotIdxOrEquilibriumPoint {
    // BY PREFIX AND SUFFIX SUM TC O(N) SC O(N)
    /*public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];

        pre[0] = nums[0];
        suff[n-1] = nums[n-1];
        for(int i=1; i<n; i++) pre[i] = pre[i-1] + nums[i];
        for(int i=n-2; i>=0; i--) suff[i] = suff[i+1] + nums[i];

        for(int i=0; i<n; i++) if(pre[i] == suff[i]) return i;
        return -1;
    }*/

    // SAME TC AND SC BUT SLIGHTLY OPTIMIZED TC O(N) SC O(N)
    /*public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] suff = new int[n];

        suff[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) suff[i] = suff[i+1] + nums[i];

        int pre = 0;
        for(int i=0; i<n; i++){
            pre += nums[i];
            if(pre == suff[i]) return i;
        }

        return -1;
    }*/

    // BEST TC O(N) SC O(1)
    public static int pivotIndex(int[] nums) {
        int tSum = 0;
        for(int num: nums) tSum += num;

        int pre = 0;
        for(int i=0; i<nums.length; i++){
            int suff = tSum - nums[i] - pre;
            if(pre == suff) return i;
            pre += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        int[] brr = {1,2,3};

        System.out.println(pivotIndex(arr)); // 3
        System.out.println(pivotIndex(brr)); // -1
    }
}
