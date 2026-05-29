package Array.PrefixSum;

public class RangeSumQueryImmutable {
    public static class NumArray{
        int[] prefix;
        NumArray(int[] nums) {
            int n = nums.length;
            prefix = new int[n];
            prefix[0] = nums[0];

            for(int i=1; i<n; i++){
                prefix[i] = prefix[i-1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if(left == 0) return prefix[right];
            return prefix[right] - prefix[left-1];
        }
    }

    public static void main(String[] args) {

    }
}