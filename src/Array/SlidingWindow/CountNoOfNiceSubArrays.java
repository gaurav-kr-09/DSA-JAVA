package Array.SlidingWindow;

// THIS PROBLEM IS SAME AS BINARY SUBARRAY WITH SUM
public class CountNoOfNiceSubArrays {
    // Method 1: using hashmap TC(O(n)) SC(O(n))
    /*public static int numberOfSubarrays(int[] nums, int k) {
        int ans=0;
        HashMap<Integer, Integer> oddCntMap = new HashMap<>();
        oddCntMap.put(0, 1); // odd count 0 is 1

        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 != 0) oddCount++;

            if (oddCntMap.containsKey(oddCount - k)) ans += oddCntMap.get(oddCount - k);

            oddCntMap.put(oddCount, oddCntMap.getOrDefault(oddCount, 0) + 1);
        }

        return ans;
    }*/

    // Method 2: 1 pass optimal -> slight difficult reading TC(O(n)) SC(O(1))
    /*public static int numberOfSubarrays(int[] nums, int k) {
        int ans=0, oCnt=0;
        int i=0, j=0;
        int eCnt = 0;
        while(j < nums.length){
            if(nums[j] % 2 != 0) oCnt++;

            while (i < j && (nums[i] % 2 == 0 || oCnt > k)){
                if(nums[i] % 2 == 0) eCnt++;
                else{
                    eCnt = 0;
                    oCnt--;
                }
                i++;
            }

            if(oCnt == k) ans += 1 + eCnt;
            j++;
        }

        return ans;
    }*/

    // Method 3: 2 pass -> best readability TC(O(n)) SC(O(1))
    public static int numberOfSubarrays(int[] nums, int k) {
        return atMostOdds(nums, k) - atMostOdds(nums, k-1);
    }

    private static int atMostOdds(int[] nums, int k) {
        if(k < 0) return 0;

        int ans = 0;
        int oCnt = 0;
        int i=0, j=0;
        while (j < nums.length){
            if(nums[j] % 2 != 0) oCnt++;

            while(oCnt > k){
                if(nums[i] % 2 != 0) oCnt--;
                i++;
            }

            ans += (j-i+1);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        int k = 3; // ans -> 2
        System.out.println(numberOfSubarrays(arr, k));

        int[] brr = {2,2,2,1,2,2,1,2,2,2};
        k = 2; // ans -> 16
        System.out.println(numberOfSubarrays(brr, k));
    }
}