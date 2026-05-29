package Array.MissingQns;

public class MedianOfTwoSortedArrays {
    // bruteforce TC-> O(m+n), SC-> O(1)
    /*public static double findMedian(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m+n;

        int mid1 = (total-1)/2;
        int mid2 = total/2;

        int i=0, j=0, k=0;
        int a = 0, b=0;

        while(i < m || j < n){
            int val;
            if(i < m && (j >= n || nums1[i] <= nums2[j])) val = nums1[i++];
            else val = nums2[j++];

            if(k == mid1) a = val;
            if(k == mid2){
                b = val;
                break;
            }

            k++;
        }

        return total % 2 == 0 ? (a+b)/2.0 : b;
    }*/

    // Optimized
    public static double findMedian(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedian(nums2, nums1);
        // X denotes nums1 and Y nums2
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x; // not x-1

        while(low <= high){
            int partX = (low+high) / 2; // length of part of nums1 in left side
            int partY = (x+y+1)/2 - partX; // length of part of nums2 in left side (half - partX)

            // nums1 ka last element (left part), nums2 ka first element (right part) se chhota hona chahiye
            // nums2 ka last element (left part), nums1 ka first element (right part) se chhota hona chahiye
            // but wo sab agar available hi nahi hai to +- INF se adjust karna parega

            int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX]; // nums1 ka sara element left me chala gaya

            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1]; // nums2 ka sara element right me chala gaya
            int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];

            // agar sorted ho gaya to
            if(xLeft <= yRight && yLeft <= xRight){
                // result based on even or odd total
                if((x+y)%2 == 0)
                    return (Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2.0;
                else return Math.max(xLeft, yLeft);
            }
            else if(xLeft > yRight) high = partX - 1;
            else low = partX+1;
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,5,8,9};
        int[] brr = {1,2,4,6,7,10};
        System.out.println(findMedian(arr, brr)); // 5.0
    }
}