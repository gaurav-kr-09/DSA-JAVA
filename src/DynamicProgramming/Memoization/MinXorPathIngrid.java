package DynamicProgramming.Memoization;

public class MinXorPathIngrid {
    // ye kam to kar rha hai but ye achha solution nahi hai (tukka hai)
    /*public static int m, n;
    public static int[][][] dp;
    public static int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n][1024];
        for(int[][] temp: dp)
            for(int[] row: temp) Arrays.fill(row, -1);

        return paths(0, 0, grid, 0);
    }

    public static int paths(int cr, int cc, int[][] grid, int xor) {
        if(cr >= m || cc >= n) return Integer.MAX_VALUE; // bahar;

        xor ^= grid[cr][cc];

        if(cr == m-1 && cc == n - 1) return xor; // exact destination

        // isko niche isiliye la rhe hai kyuki curr wale ka v xor lena hai
        if(dp[cr][cc][xor] != -1) return dp[cr][cc][xor];

        int right = paths(cr, cc+1, grid, xor);
        int down = paths(cr+1, cc, grid, xor);

        return dp[cr][cc][xor] = Math.min(right, down);
    }*/

    // isme ye dikkat hai ki ham ye nahi bata sakte ki ya to
    // upar wala ya niche wala path se minimum xor aayega
    // kyuki chhote se xor karne k bad v min xor value aa sakta hai
    // and bade se xor karne k bad v min xor val aa sakta hai
    // ex-> curr = 3 and chhota = 2 -> 3 ^ 2 = 1 &
    // bada = 4 -> 3 ^ 4 = 7 i.e bada wala jyada &
    // ex -> curr = 6 and chhota = 5 -> 6 ^ 5 = 3
    // bada = 7 -> 7 ^ 6 = 1 i.e chhota wala jyada
    // so we have to store all possible xors jo ho sakta kai
    // kisi v cell tak -> uske liye ham array use kar sakte hai
    // but array me bar bar xor karna bahut slow hoga kyuki pura
    // array bar bar traverse karna hoga and upar and left ka
    // curr se xor kar kar ke store karna parega, so usko fast
    // karne k liye we can use bitset jo ki isi type k  oprn k liye
    // inbuilt hai and faster v hai.
    // aab main qn ki ye bitset rahega kitne size ka ?
    // qn k according each cell ka value 0-1023 so isko represent karne
    // k liye max 1024 states needed &
    // dp[i][j] pe 1024 size ka ek array samajh lo and jis index ka
    // bit 1 hai matlab start se waha tak aane ka min ek path hai jiska
    // xor ka aab tak ka value index k barabar hai
    // Ex -> dp[i][j] ke index 5 pe 1 bit hai means start se koi ek rasta
    // tha jaha se i,j tak aane me xor ka val 5 hai so solution becomes
    /*public static int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // bitset ka dp bana liye for
        BitSet[][] dp = new BitSet[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j] = new BitSet(1024);

        // start k cell me dp ka start ka value dal do
        dp[0][0].set(grid[0][0]); // ye start k value k bit ko 1 kar dega

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // starting cell ka value to pahle hi dal chuke hai
                if(i == 0 && j == 0) continue;

                BitSet prevStates = new BitSet(1024);
                if(i > 0) prevStates.or(dp[i-1][j]);
                if(j > 0) prevStates.or(dp[i][j-1]);

                for (int xorVal = 0; xorVal < 1024; xorVal++)
                    if(prevStates.get(xorVal)) // agar 1 hai
                        dp[i][j].set(xorVal ^ grid[i][j]);
            }
        }

        for (int xorVal = 0; xorVal < 1024; xorVal++)
            if (dp[m - 1][n - 1].get(xorVal)) return xorVal;

        return -1;
    }*/

    // Dekho jab ham upar me basically true and false hi store kar rhe hai
    // to kyu na bitset k badle boolean dp hi use kar le
    public static int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp bana liye & by default sara false
        boolean[][][] dp=new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true; // starting wale ko true kiye

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // starting cell ka value to pahle hi dal chuke hai
                if(i == 0 && j == 0) continue;

                int curr = grid[i][j];
                if(i > 0){
                    for(int xorVal = 0; xorVal < 1024; xorVal++)
                        if(dp[i-1][j][xorVal]) // agar true hai
                            dp[i][j][xorVal ^ curr] = true;
                }

                if(j > 0){
                    for(int xorVal = 0; xorVal < 1024; xorVal++)
                        if(dp[i][j-1][xorVal]) // agar true hai
                            dp[i][j][xorVal ^ curr] = true;
                }
            }
        }

        for (int xorVal = 0; xorVal < 1024; xorVal++)
            if (dp[m-1][n-1][xorVal]) return xorVal;

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 2},
                {3, 4}
        };
        System.out.println(minCost(grid1)); // Expected: 6

        int[][] grid2 = {
                {6, 7},
                {5, 8}
        };
        System.out.println(minCost(grid2)); // Expected: 9

        int[][] grid3 = {
                {2, 7, 5}
        };
        System.out.println(minCost(grid3)); // Expected: 0

        int[][] grid4 = {
                {5}
        };
        System.out.println(minCost(grid4)); // Expected: 5

        int[][] grid5 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(minCost(grid5)); // Expected: 1
    }
}