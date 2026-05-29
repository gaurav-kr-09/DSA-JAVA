package CountBucketRadixSort;

public class RadixSort {
    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int a : arr) max = Math.max(max, a);
        return max;
    }

    private static void LSDRadixSort(int[] arr) {
        // Step 1: find max value to apply max k digit jitna count sort
        int max = findMax(arr);

        // Step 2: applying loop digits of max times
        for (int place = 1; max / place > 0; place *= 10) {
            countSort(arr, place);
        }
    }

    // helper countSort function
    private static void countSort(int[] arr, int place) {
        // Step 1: make a frequency array of 10 size (0-9)
        int[] freq = new int[10];

        // Step 2: filling the frequency array with digit nth place i.e (num/n) % 10
        for (int a : arr) {
            freq[(a / place) % 10]++;
        }

        // Step 3: make prefix sum of frequency array
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        // Step 4: sorting the array stably according to (place)th digit
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int currElem = (arr[i] / place) % 10;
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
        int[] arr = {43, 453, 626, 894, 0, 3};
        System.out.print("Original array is: ");
        display(arr);

        LSDRadixSort(arr);

        System.out.print("Sorted array is: ");
        display(arr);
    }
}
