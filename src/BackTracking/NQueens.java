package BackTracking;

public class NQueens {
    private static void nqueen(char[][] board, int row){
        int n = board.length;
        if(row == n){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++) System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            return;
        }

        // check if the row is safe
        for(int i=0; i<n; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                nqueen(board, row+1);
                board[row][i] = 'X'; // backtrack
            }
        }
    }

    // Not optimal
    /*private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        // Check row
        // Row v check karne ka jarurat nahi hai
        for(int i=0; i<n; i++){
            if(board[row][i] == 'Q') return false;
        }

        // Check col
        for(int i=0; i<n; i++){
            if(board[i][col] == 'Q') return false;
        }

        // check north-east
        int i=row, j=col;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        // THESE TWO ARE NOT NEEDED KYUKI QUEEN UPAR SE NICHE DALTE HAI, TO NICHE TO WAISE V NAHI HOGA
        // check south-east
        i=row; j=col;
        while(i < n && j < n){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }

        // check south-west
        i=row; j=col;
        while(i < n && j >=0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        // This is needed
        // check north-west
        i=row; j=col;
        while(i >= 0 && j >=0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        return true;
    }*/

    // optimized isSafe
    private static boolean isSafe(char[][] board, int row, int col) {
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
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) board[i][j] = 'X';
        }

        nqueen(board, 0);
    }
}
