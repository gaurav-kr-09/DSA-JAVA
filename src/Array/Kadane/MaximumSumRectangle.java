package Array.Kadane;

public class MaximumSumRectangle {
    // METHOD 1: BRUTEFORCE TYPE TC-> O(NSQ * MSQ)
    /*public static int maxRectSum(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        // PREFIX SUM FOR ROWS
        for(int i=0; i<row; i++){
            for(int j=1; j<col; j++){
                mat[i][j] += mat[i][j-1];
            }
        }

        // PREFIX SUM FOR COLUMNS
        for(int j=0; j<col; j++){
            for(int i=1; i<row; i++){
                mat[i][j] += mat[i-1][j];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int x=i; x<row; x++){
                    for(int y=j; y<col; y++){
                        // sum of matrix (i, j) -> (x, y)
                        int sum = findSum(mat, i, j, x, y);
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }

        return maxSum;
    }

    private static int findSum(int[][] mat, int i, int j, int x, int y){
        int ans = mat[x][y];
        if(j-1 >= 0) ans -= mat[x][j-1];
        if(i-1 >= 0) ans -= mat[i-1][y];
        if(i-1 >= 0 && j-1 >= 0) ans += mat[i-1][j-1];

        return ans;
    }*/

    // METHOD 2: optimal KADANE -> tc O(row sq * col)
    public static int maxRectSum(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<row; i++){ // Ye batayega kitni bar karna hai
            int[] sum = new int[col];

            // aab har row se start hoke aage tak
            for (int j = i; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    sum[k] += mat[j][k];
                }
                maxSum = Math.max(maxSum, kadane(sum));
            }
        }

        return maxSum;
    }

    private static int kadane(int[] arr){
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : arr) {
            currSum = Math.max(num, num + currSum);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    // ISKO COLUMN WISE SUM KARKE V BANA SAKTE HAI

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6},
        };

        // https://www.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1
        System.out.println(maxRectSum(arr)); // ANS -> 29
    }
}
