package BackTracking;

public class SudokuSolver {
    public static boolean solved;
    public static void solveSudoku(char[][] board) {
        solved=false;
        solve(board, 0, 0);
    }

    public static void solve(char[][] board, int row, int col){
        if(row == 9){
            solved = true;
            return;
        }

        if(board[row][col] != '.') {
            if(col < 8) solve(board, row, col+1);
            else solve(board, row+1, 0);
        }else{
            for(char ch='1'; ch <= '9'; ch++){
                if(isValid(board, row, col, ch)){
                    board[row][col] = ch;
                    if(col < 8) solve(board, row, col+1);
                    else solve(board, row+1, 0);

                    if(solved) return;
                    board[row][col] = '.'; // backtracking if not solved
                }
            }
        }
    }

    public static boolean isValid(char[][] board, int row, int col, char elem){
        // Check row
        for(int c=0; c<9; c++){
            if(board[row][c] == elem) return false;
        }

        // Check col
        for(int r=0; r<9; r++){
            if(board[r][col] == elem) return false;
        }

        // check 3x3 board
        int sRow = (row/3)*3;
        int sCol = (col/3)*3;
        for(int i=sRow; i<sRow+3; i++){
            for(int j=sCol; j<sCol+3; j++){
                if(board[i][j] == elem) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board ={
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };

        for(char[] ch: board){
            for(char c: ch) System.out.print(c + "  ");
            System.out.println();
        }
        System.out.println();

        solveSudoku(board);
        for(char[] ch: board){
            for(char c: ch) System.out.print(c + "  ");
            System.out.println();
        }
    }
}