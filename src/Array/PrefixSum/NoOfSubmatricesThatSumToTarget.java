package Array.PrefixSum;

import java.util.HashMap;

public class NoOfSubmatricesThatSumToTarget {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;

        for(int i=0; i<row; i++){

            // COMPRESSING THE ARRAY
            int[] sum = new int[col];
            for (int j = i; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    sum[k] += matrix[j][k];
                }

                // NOW FINDING IF PREFIX SUM IS EQUAL TO TARGET ON EACH FLATTEN ARRAY
                // SAME AS LEETCODE 560 Subarray Sum Equals K
                HashMap<Integer, Integer> freq = new HashMap<>();
                freq.put(0, 1);
                int pre = 0;
                for(int num: sum){
                    pre += num;
                    if(freq.containsKey(pre - target)) count += freq.get(pre-target);
                    freq.put(pre, freq.getOrDefault(pre, 0)+1);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{0,1,0},{1,1,1},{0,1,0}};
        int target = 0; // ans -> 4
        System.out.println(numSubmatrixSumTarget(matrix1, target));

        int[][] matrix2 = {{1,-1},{-1,1}};
        target = 0; // ans -> 5
        System.out.println(numSubmatrixSumTarget(matrix2, target));
    }
}