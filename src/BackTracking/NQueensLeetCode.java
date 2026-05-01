package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NQueensLeetCode {
    // Method 1
    /*public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) board[i][j] = '.';
        }
        nqueen(board, 0, ans);
        return ans;
    }

    static void nqueen(char[][] board, int row, List<List<String>> ans){
        int n = board.length;
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++){
                    sb.append(board[i][j]);
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        // check if the row is safe
        for(int i=0; i<n; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                nqueen(board, row+1, ans);
                board[row][i] = '.'; // backtrack
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check col (upar)
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q') return false;
        }

        // check north-east
        int i=row, j=col;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        // check north-west
        i=row; j=col;
        while(i >= 0 && j >=0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        return true;
    }*/

    // Method 2
    /*public static HashSet<Integer> cols = new HashSet<>();
    public static HashSet<Integer> diag = new HashSet<>();
    public static HashSet<Integer> antiDiag = new HashSet<>();

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] b: board){
            Arrays.fill(b, '.');
        }

        nqueen(board, 0, ans);
        return ans;
    }

    static void nqueen(char[][] board, int row, List<List<String>> ans){
        int n = board.length;
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) temp.add(new String(board[i]));
            ans.add(temp);
            return;
        }

        // Check if the row is safe
        for(int col=0; col<n; col++) {
            int diagConst = row + col;
            int antiDiagCOnst = row - col;

            if(cols.contains(col) || diag.contains(diagConst) || antiDiag.contains(antiDiagCOnst))
                continue;

            cols.add(col);
            diag.add(diagConst);
            antiDiag.add(antiDiagCOnst);

            board[row][col] = 'Q';
            nqueen(board, row+1, ans);

            // backtrack
            cols.remove(col);
            diag.remove(diagConst);
            antiDiag.remove(antiDiagCOnst);

            board[row][col] = '.';
        }
    }*/

    // Method 3: same as 2 but better
    private static boolean[] cols;
    private static boolean[] diag;
    private static boolean[] antiDiag;

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        cols = new boolean[n];
        diag = new boolean[2*n];
        antiDiag = new boolean[2*n];

        char[][] board = new char[n][n];
        for(char[] b: board) Arrays.fill(b, '.');
        nqueen(board, 0, ans);
        return ans;
    }

    private static void nqueen(char[][] board, int row, List<List<String>> ans){
        int n = board.length;
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) temp.add(new String(board[i]));
            ans.add(temp);
            return;
        }

        for(int col=0; col<n; col++) {
            int diagConst = row + col;
            int antiDiagConst = row - col + (n-1); // + (n-1) to make it +ve

            if(cols[col] || diag[diagConst] || antiDiag[antiDiagConst])
                continue;

            cols[col] = diag[diagConst] = antiDiag[antiDiagConst] = true;
            board[row][col] = 'Q';
            nqueen(board, row+1, ans);
            // backtrack
            cols[col] = diag[diagConst] = antiDiag[antiDiagConst] = false;
            board[row][col] = '.';
        }
    }

    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(6);
        for(List<String> ls: ans){
            for(String s: ls) System.out.println(s);
            System.out.println();
        }
    }
}