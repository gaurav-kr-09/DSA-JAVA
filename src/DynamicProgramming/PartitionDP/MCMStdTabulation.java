package DynamicProgramming.PartitionDP;

public class MCMStdTabulation {
    public static int MCM(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];
        // for(int i=1; i<n; i++) dp[i][i] = 0; // base case -> same matrix ka multiplication cost 0

        for(int cl = 2; cl<=n-1; cl++){ // chain length goes from 2 to n
            for(int i=1; i<=(n-cl); i++){ // j valid hona chahiye so n-cl
                int j = i+cl-1; // j will start from i and will go to cl but for indexing do -1

                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){ // ye to pahle v kar chuke hai recursion wale me
                    int C = arr[i-1] * arr[k] * arr[j];
                    int tc = dp[i][k] + dp[k+1][j] + C;
                    dp[i][j] = Math.min(dp[i][j], tc);
                }
            }
        }

        return dp[1][n-1];
    }

    public static void main(String[] args) {

        int[] arr1 = {40, 20, 30, 10, 30};
        System.out.println(MCM(arr1)); // 26000

        int[] arr2 = {10, 20, 30, 40, 30};
        System.out.println(MCM(arr2)); // 30000

        int[] arr3 = {10, 20, 30};
        System.out.println(MCM(arr3)); // 6000

        int[] arr4 = {10, 20, 30, 40, 50};
        System.out.println(MCM(arr4)); // 38000

        int[] arr5 = {10, 20};
        System.out.println(MCM(arr5)); // 0

        int[] arr6 = {5, 10, 3, 12, 5, 50, 6};
        System.out.println(MCM(arr6)); // 2010
    }
}