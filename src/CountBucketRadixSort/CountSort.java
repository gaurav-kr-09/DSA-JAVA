package CountBucketRadixSort;

public class CountSort {
    // method 1: Not Stable
    private static void countSortUnstable1(int[] arr) {
        int n = arr.length;

        // Step 1: make frequency array of length equal to array length
        int[] freq = new int[n+1];
        for(int a: arr){
            freq[a]++;
        }

        // Step 2: put the elements same as no. of their frequency in arr
        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                arr[idx++] = i;
            }
        }
    }

    // method 2: Not Stable
    private static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int a: arr) max = Math.max(max, a);
        return max;
    }

    private static void countSortUnstable2(int[] arr) {
        // Step 1: make frequency array of length equal to max Element in array
        int max = findMax(arr);
        int[] freq = new int[max +1];
        for(int a: arr){
            freq[a]++;
        }

        // Step 2: put the elements same as no. of their frequency in arr
        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                arr[idx++] = i;
            }
        }
    }

    // method 3 - Stable
    private static void countSortStable(int[] arr) {
        // Step 1: make frequency array of length equal to max Element in array
        int max = findMax(arr);
        int[] freq = new int[max + 1];
        for (int a : arr) {
            freq[a]++;
        }

        // Step 2: make prefix sum of frequency array
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        // Step 3: sorting the array stably arr k pichhe se utha k ans bharo
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int currElem = arr[i];
            int idx = freq[currElem] - 1; // prefix[i] isse position and, -1 se idx
            ans[idx] = arr[i];
            freq[currElem]--;
        }

        // Step 4: copy all elements of answer to original array
        for (int i = 0; i < n; i++) arr[i] = ans[i];
    }

    private static void display(int[] arr){
        for(int a: arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,5,3,1,3,5};
        System.out.print("Original array is: ");
        display(arr);
        countSortUnstable1(arr);
        System.out.print("Sorted array is: ");
        display(arr);

        System.out.println("+++++++++++++++++++++++++++++++++++++");

        int[] brr = {4,3,1,5,3,1,3,5};
        System.out.print("Original array is: ");
        display(brr);
        countSortUnstable2(brr);
        System.out.print("Sorted array is: ");
        display(brr);

        System.out.println("+++++++++++++++++++++++++++++++++++++");

        int[] crr = {4,3,1,5,3,1,3,5};
        System.out.print("Original array is: ");
        display(crr);
        countSortStable(crr);
        System.out.print("Sorted array is: ");
        display(crr);
    }
}
