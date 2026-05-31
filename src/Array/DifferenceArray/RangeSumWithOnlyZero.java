package Array.DifferenceArray;

public class RangeSumWithOnlyZero {
    private static void rangeSum(int[] arr, int[][] queries){
        int n = arr.length;
        for (int[] query : queries) {
            int a = query[0], b = query[1], c=query[2];

            arr[a] += c;
            if(b + 1 < n) arr[b+1] -= c;
        }

        for (int i = 1; i < n; i++) arr[i] += arr[i - 1];
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0}; // -2, 0, 3, 5, 3
        int[][] updateQueries = {{1,3,2}, {2,4,3}, {0,2,-2}};
        rangeSum(arr, updateQueries);

        for(int a: arr) System.out.print(a + " ");
    }
}