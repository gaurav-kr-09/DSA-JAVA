package BackTracking;

import java.util.Arrays;

public class NQueens2 {
    public static int count;
    static boolean[] cols;
    static boolean[] diag;
    static boolean[] antiDiag;

    public static int totalNQueens(int n) {
        count = 0;
        cols = new boolean[n];
        diag = new boolean[2*n];
        antiDiag = new boolean[2*n];

        char[][] board = new char[n][n];
        for(char[] b: board) Arrays.fill(b, '.');
        nqueen(board, 0);
        return count;
    }

    static void nqueen(char[][] board, int row){
        int n = board.length;
        if(row == n){
            count++;
            return ;
        }

        // check if the row is safe
        for(int col=0; col<n; col++) {
            int diagConst = row + col;
            int antiDiagConst = row - col + (n-1); // + (n-1) to make it +ve

            if(cols[col] || diag[diagConst] || antiDiag[antiDiagConst])
                continue;

            cols[col] = diag[diagConst] = antiDiag[antiDiagConst] = true;
            board[row][col] = 'Q';
            nqueen(board, row+1);
            // backtrack
            cols[col] = diag[diagConst] = antiDiag[antiDiagConst] = false;
            board[row][col] = '.';
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(3));
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(5));
        System.out.println(totalNQueens(6));
    }
}