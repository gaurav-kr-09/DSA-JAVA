package BackTracking;

public class MaxKnightsInNxNBoard {
    // Method 1: using formula
    /*public static int maxKnights = -1;
    public static void countKnights(char[][] board, int row, int col, int knightsPlaced){
        int n = board.length;
        maxKnights = n <= 2 ? n * n : (n * n + 1) / 2;
    }*/

    // Method 2 backtracking
    /*public static int[][] dir = {
        {-2, 1}, {-2, -1},
        {2, 1}, {2, -1},
        {1, 2}, {-1, 2},
        {1, -2}, {-1, -2}
    };

    private static boolean isSafe(char[][] board, int row, int col){
        int n = board.length;

        for(int[] d: dir){
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n && board[nr][nc] == 'K') return false;
        }

        return true;
    }

    private static int maxKnights = -1;

    public static void countKnights(char[][] board, int row, int col, int knightsPlaced){
        int n = board.length;
        if(row == n){
//            for(int i=0; i<n; i++){
//                for(int j=0; j<n; j++) System.out.print(board[i][j] + " ");
//                System.out.println();
//            }
//            System.out.println();
            maxKnights = Math.max(maxKnights, knightsPlaced);
            return;
        }
        else if(isSafe(board, row, col)){
            board[row][col] = 'K';
            if(col != n-1) countKnights(board, row, col+1, knightsPlaced+1);
            else countKnights(board, row+1, 0, knightsPlaced+1);
            board[row][col] = 'X';
        }

        if(col != n-1) countKnights(board, row, col+1, knightsPlaced);
        else countKnights(board, row+1, 0, knightsPlaced);
    }*/

    // Method 3: similar but little optimized
    // niche check karne ka jarurat nhi hai
    public static int[][] dir = {
        {-2, 1}, {-2, -1},
        {-1, 2}, {-1, -2}
    };

    private static boolean isSafe(char[][] board, int row, int col){
        int n = board.length;

        for(int[] d: dir){
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n && board[nr][nc] == 'K') return false;
        }

        return true;
    }

    private static int maxKnights = -1;
    public static void countKnights(char[][] board, int row, int col, int knightsPlaced){
        int n = board.length;
        if(row == n){
            maxKnights = Math.max(maxKnights, knightsPlaced);
            return;
        }

        if(isSafe(board, row, col)){
            board[row][col] = 'K';
            if(col != n-1) countKnights(board, row, col+1, knightsPlaced+1);
            else countKnights(board, row+1, 0, knightsPlaced+1);
            board[row][col] = 'X';
        }

        if(col != n-1) countKnights(board, row, col+1, knightsPlaced);
        else countKnights(board, row+1, 0, knightsPlaced);
    }

    public static void main(String[] args) {
        int n = 3;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) board[i][j] = 'X';
        }
        countKnights(board, 0, 0, 0);
        System.out.println(maxKnights);
    }
}