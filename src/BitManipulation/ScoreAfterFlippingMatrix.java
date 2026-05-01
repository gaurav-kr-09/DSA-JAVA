package BitManipulation;

public class ScoreAfterFlippingMatrix {
    public static int matrixScore(int[][] grid) {
        // Step 1: 0th col of each row ko 1 bana do
        int m = grid.length, n=grid[0].length;

        for(int[] row: grid){
            if(row[0] == 0){
                for(int i=0; i<row.length; i++) row[i] = row[i] ^ 1;
            }
        }

        // Step 2: har us col k bits ko flip karo jisme no. of 0 > no. of 1
        for(int i=1; i<n; i++){ // i = 1 not 0 kyuki pahla column me  to sara 0 hi hai
            int zeroCnt = 0;
            for(int j=0; j<m; j++){
                if(grid[j][i] == 0) zeroCnt++;
            }

            if(zeroCnt > (m - zeroCnt)){ // flip that col
                for(int j=0; j<m; j++) grid[j][i] ^= 1;
            }
        }

        // add the score and return
        int sum=0;
        for(int[] row: grid){
            int temp = 0;
            for(int b: row){
                temp = temp * 2 + b;
            }
            sum += temp;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,1,1},{1,0,1,0},{1,1,0,0}}; // ans 39
        System.out.println("Max score is: "+ matrixScore(matrix));
    }
}
