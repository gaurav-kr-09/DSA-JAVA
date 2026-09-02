package DynamicProgramming.Tabulation;

import java.util.Arrays;

public class UniquePathsLC62 {
    // DIRECT TABULATION
    /*public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0) dp[i][j] = 1;
                // dp[i][j] = upar + left
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }*/

    // SPACE OPTIMIZED
    /*public static int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n]; // 2 X n array

        for (int i=0; i<n; i++) {
            dp[0][i] = 1; // pehla row fill kar liye 1 se
            dp[1][i] = 1; // 2 row v 1 se fill
        }

        for(int i=1; i<m; i++){ // m-1 times
            // 1st row fill kiya
            for(int j=1; j<n; j++){
                dp[1][j] = dp[1][j-1] + dp[0][j];
            }

            // 0th row me 1st ko copy kiya
            for(int j=1; j<n; j++){
                dp[0][j] = dp[1][j];
            }
        }

        // last element return kar diya
        return dp[1][n-1];
    }*/

    // Space optimized without copying
    /*public static int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n]; // 2 X n array

        for (int i=0; i<n; i++) {
            dp[0][i] = 1; // pehla row fill kar liye 1 se
            dp[1][i] = 1; // 2 row v 1 se fill
        }

        for(int i=1; i<m; i++){ // m-1 times
            if(i % 2 == 1){
                for(int j=1; j<n; j++){
                    dp[1][j] = dp[1][j-1] + dp[0][j];
                }
            }else{
                for(int j=1; j<n; j++){
                    dp[0][j] = dp[0][j-1] + dp[1][j];
                }
            }
        }

        // jo max hoga wo answer kar do dono k last cell me se
        return Math.max(dp[0][n-1], dp[1][n-1]);
    }*/

    // Best space optimized
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1; i<m; i++){ // m-1 times
            for(int j=1; j<n; j++){
                // dp[j] = up + left
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 7));   // 28

        System.out.println(uniquePaths(3, 2));   // 3

        System.out.println(uniquePaths(7, 3));   // 28

        System.out.println(uniquePaths(3, 3));   // 6

        System.out.println(uniquePaths(1, 1));   // 1

        System.out.println(uniquePaths(1, 5));   // 1

        System.out.println(uniquePaths(5, 1));   // 1

        System.out.println(uniquePaths(10, 10)); // 48620
    }
}
