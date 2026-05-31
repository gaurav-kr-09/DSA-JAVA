package Array.DifferenceArray;

public class RangeSumWithOtherNumbers {
    // Method 1
    /*private static int[] rangeSum(int[] arr, int[][] queries){
        int n = arr.length;

        // step 1: make the difference array
        int[] diff = new int[n];
        diff[0] = arr[0];
        for(int i=1; i<n; i++) {
            diff[i] = arr[i] - arr[i-1];
        }

        // step 2: applying queries on difference array
        for (int[] query : queries) {
            int a = query[0], b = query[1], c=query[2];
            diff[a] += c;
            if(b+1 < n) diff[b+1] -= c;
        }

        // step 3: make prefix sum of difference array
        for (int i = 1; i < n; i++) diff[i] += diff[i-1];

        return diff;
    }*/

    // Method 2:
    private static int[] rangeSum(int[] arr, int[][] queries){
        int n = arr.length;

        // Step 1: make the difference array
        int[] diff = new int[n];
        for (int[] query : queries) {
            int a = query[0], b = query[1], c=query[2];
            diff[a] += c;
            if(b+1 < n) diff[b+1] -= c;
        }

        // Step 2: make prefix sum of difference array
        for (int i = 1; i < n; i++) diff[i] += diff[i-1];

        // Step 3: apply changes to original array data
        for(int i=0; i<n; i++) diff[i] += arr[i];

        return diff;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0}; // -2, 0, 3, 5, 3
        int[][] updateQueries = {{1,3,2}, {2,4,3}, {0,2,-2}};
        int[] diff = rangeSum(arr, updateQueries);
        for(int d: diff) System.out.print(d + " ");

        System.out.println();

        int[] brr = {10,20,30,40,50}; // 20 35 45 45 50
        int[][] queries = {{1,3,5}, {0, 2, 10}};
        int[] diff2 = rangeSum(brr, queries);
        for(int d : diff2) System.out.print(d + " ");
    }
}
