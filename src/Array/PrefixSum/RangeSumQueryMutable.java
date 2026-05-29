package Array.PrefixSum;

public class RangeSumQueryMutable {
    public static class NumArray{
        int[] arr;
        int[] prefix;

        public NumArray(int[] nums) {
            arr = nums;
            int n = nums.length;
            prefix = new int[n];
            prefix[0] = nums[0];

            for(int i=1; i<n; i++){
                prefix[i] = prefix[i-1] + nums[i];
            }
        }

        public void update(int index, int val) {
            // Index se ant tak sara pre me se arr[index]-val ghata do
            int diff = arr[index] - val;
            arr[index] = val;

            for(int i=index; i<prefix.length; i++){
                prefix[i] -= diff;
            }
        }

        public int sumRange(int left, int right) {
            if(left == 0) return prefix[right];
            return prefix[right] - prefix[left-1];
        }
    }

    // ABHI ISKA TC update O(N) sumRange O(1)
    // ISKA OPTIMAL SOLUTION NIKALTA HAI Fenwick Tree aur Segment Tree -> ISME TC DONO KA O(logN)

    public static void main(String[] args) {

    }
}