package Array;

public class MinMovesToEqualArrayElements {
    // BruteForce - definitely TLE Dega
    /*public static int minMoves(int[] nums) {
        int moves = 0;

        while(!allEleEqual(nums)){
            int maxIdx = findMaxIdx(nums);
            for(int i=0; i<nums.length; i++){
                if(i == maxIdx) continue;
                nums[i]++;
            }
            moves++;
        }

        return moves;
    }

    public static boolean allEleEqual(int[] nums){
        int first = nums[0];
        for(int num: nums){
            if(num != first) return false;
        }
        return true;
    }

    public static int findMaxIdx(int[] nums){
        int maxIdx = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }*/

    // Agar aise soche ki elements k bich k gap ko min ele
    // ke barabar karna hai to bat aasani se ban jayega
    // i.e sabhi ele ko me se min ko ghata k ans me add karte jayenge
    // codeStoryWithMIK
    /*public static int minMoves(int[] nums) {
        int min = nums[0];
        for(int num: nums) min = Math.min(min, num);

        int moves = 0;
        for(int num: nums) moves += (num - min);

        return moves;
    }*/

    // isko thora or optimize kar sakte hai, dekho sare elements me se
    // min ghata rhe hai, to kyu na sare elements ka sum karke
    // n times min ghata le ek hi loop me kam ho jayega
    public static int minMoves(int[] nums) {
        int n = nums.length;

        int min = nums[0];
        int sum = 0;
        for(int num: nums){
            min = Math.min(min, num);
            sum += num;
        }

        return sum - (n*min);
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        System.out.println(minMoves(nums1)); // Expected: 3

        int[] nums2 = {1, 1, 1};
        System.out.println(minMoves(nums2)); // Expected: 0

        int[] nums3 = {5, 6, 8};
        System.out.println(minMoves(nums3)); // Expected: 4

        int[] nums4 = {-1, 0, 1};
        System.out.println(minMoves(nums4)); // Expected: 3

        int[] nums5 = {10};
        System.out.println(minMoves(nums5)); // Expected: 0

        int[] nums6 = {1,1000000000};
        System.out.println(minMoves(nums6)); // Expected: 999999999
    }
}