package Strings.KMPAlgo;

public class NoOfSubarraysThatMatchPattern {
    // BruteForce 3034 wala pass kar jeyega TC O(n*m) SC O(1)
    /*public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int count = 0;
        for(int i=0; i<=n-m-1; i++){
            int k = 0;
            while(k < m){
                if(pattern[k] == 1 && nums[i+k+1] > nums[i+k]) k++;
                else if(pattern[k] == 0 && nums[i+k+1] == nums[i+k]) k++;
                else if(pattern[k] == -1 && nums[i+k+1] < nums[i+k]) k++;
                else break; // ye subarray valid nahi hai
            }

            if(k == m) count++; // matlab valid subarray mila tha
        }

        return count;
    }*/

    // OPTIMAL WAY
    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int[] fp = new int[n-1]; // will store the patern followed b/w adjacent elements
        for(int i=0; i<n-1; i++){
            if(nums[i] < nums[i+1]) fp[i] = 1;
            else if(nums[i] == nums[i+1]) fp[i] = 0;
            else fp[i] = -1;
        }

        return search(pattern, fp);
    }

    public static int search(int[] patt, int[] fp){
        int n = fp.length;
        int m = patt.length;

        int[] LPS = computeLPS(patt);

        int count = 0; // store the count of occurrence os patt in fp
        // apply KMP code
        int i=0;
        int j=0;
        while(i < n){
            if(fp[i] == patt[j]){
                i++;
                j++;
            }

            if(j == m) { // mil gaya
                count++;
                j = LPS[j-1];
            }else if(i < n && fp[i] != patt[j]){
                if(j != 0) j = LPS[j-1];
                else i++;
            }
        }

        return count;
    }

    private static int[] computeLPS(int[] patt) {
        int m = patt.length;
        int[] LPS = new int[m];

        int len = 0; // length of previous equal longest prefix and suffix
        LPS[0] = 0;

        int i = 1;
        while (i < m){
            if(patt[i] == patt[len]){
                len++;
                LPS[i] = len;
                i++;
            }else{
                if(len != 0) len = LPS[len-1];
                else{
                    LPS[i] = 0;
                    i++;
                }
            }
        }

        return LPS;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] pattern1 = {1, 1};
        System.out.println(countMatchingSubarrays(nums1, pattern1)); // Expected: 4

        int[] nums2 = {1, 4, 4, 1, 3, 5, 5, 3};
        int[] pattern2 = {1, 0, -1};
        System.out.println(countMatchingSubarrays(nums2, pattern2)); // Expected: 2

        int[] nums3 = {1, 2, 1, 2, 1, 2};
        int[] pattern3 = {1, -1};
        System.out.println(countMatchingSubarrays(nums3, pattern3)); // Expected: 2

        int[] nums4 = {5, 5, 5, 5};
        int[] pattern4 = {0};
        System.out.println(countMatchingSubarrays(nums4, pattern4)); // Expected: 3

        int[] nums5 = {1, 3, 2, 4, 3};
        int[] pattern5 = {1, -1};
        System.out.println(countMatchingSubarrays(nums5, pattern5)); // Expected: 2

        int[] nums6 = {1, 2};
        int[] pattern6 = {1};
        System.out.println(countMatchingSubarrays(nums6, pattern6)); // Expected: 1
    }
}