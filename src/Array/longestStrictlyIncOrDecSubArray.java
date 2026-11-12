package Array;

public class longestStrictlyIncOrDecSubArray {
    // Bruteforce - O(Nsq)
    /*public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int ans = 0;
        for(int i = 0; i<n; i++){
            int j = i+1;
            int incr = 1;

            while(j < n && nums[j] > nums[j-1]){
                incr++;
                j++;
            }

            j = i+1;
            int decr = 1;

            while(j < n && nums[j] < nums[j-1]){
                decr++;
                j++;
            }

            ans = Math.max(ans, Math.max(incr, decr));
        }

        return ans;
    }*/

    // optimal
    public static int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int incr = 1;
        int decr = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){ // increasing
                incr++;
                decr = 1;
                ans = Math.max(ans, incr);
            }else if(nums[i] < nums[i-1]){ // decreasing
                decr++;
                incr = 1;
                ans = Math.max(ans, decr);
            }else{ // barabar
                incr = 1;
                decr = 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, 4, 3, 3, 2},
                {3, 3, 3, 3},
                {3, 2, 1},
                {1, 2, 3, 4},
                {1, 2, 2, 3, 4}
        };

        int[] expected = {2, 1, 3, 4, 3};

        for (int i = 0; i < tests.length; i++) {
            int result = longestMonotonicSubarray(tests[i]);

            System.out.println(
                    "Test " + (i + 1) +
                            " | Expected: " + expected[i] +
                            " | Actual: " + result
            );
        }
    }
}