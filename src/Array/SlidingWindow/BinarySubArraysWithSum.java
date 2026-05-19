package Array.SlidingWindow;

public class BinarySubArraysWithSum {
    // Using HashMap TC O(N) SC O(N)
    /*public static int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0, count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for(int n: nums){
            sum += n;
            if(freq.containsKey(sum-goal)) count += freq.get(sum-goal);
            freq.put(sum, freq.getOrDefault(sum , 0)+1);
        }

        return count;
    }*/

    // USING SLIDING WINDOW TC O(N) SC O(1)
    /*public static int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0, sum=0;

        int i=0, j=0;
        int zeroCnt = 0;
        while(j < nums.length){
            sum += nums[j];

            while (nums[i] == 0 || sum > goal){
                if(nums[i] == 0) zeroCnt++;
                else zeroCnt = 0;

                sum -= nums[i];
                i++;
            }

            if(sum == goal) ans += 1 + zeroCnt;

            j++;
        }

        return ans;
    }*/

    // Textbook solution using SLIDING WINDOW
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }

    private static int atMost(int[] nums, int goal) {
        if(goal < 0) return 0;

        int sum = 0, count = 0;
        int i=0, j=0;
        while (j < nums.length){
            sum += nums[j];

            while (sum > goal) sum -= nums[i++];

            count += (j-i+1);
            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1}; // ans 4
        System.out.println(numSubarraysWithSum(arr,  2));
    }
}