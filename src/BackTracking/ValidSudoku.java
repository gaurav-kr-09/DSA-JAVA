package BackTracking;

import java.util.HashSet;

public class ValidSudoku {
    // Method 1: Most readable O(81)
    /*public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char elem = board[i][j];
                if(elem != '.'){
                    board[i][j] = '.';
                    if(!isValid(board, i, j, elem)) return false;
                    board[i][j] = elem;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, int elem){
        // Check row
        for(int c=0; c<9; c++){
            if(board[row][c] == elem) return false;
        }

        // Check col
        for(int r=0; r<9; r++){
            if(board[r][col] == elem) return false;
        }

        // check 3x3 grid
        int sRow = (row/3)*3;
        int sCol = (col/3)*3;
        for(int i=sRow; i<sRow+3; i++){
            for(int j=sCol; j<sCol+3; j++){
                if(board[i][j] == elem) return false;
            }
        }

        return true;
    }*/

    // Method 2: Hashset wala O(1)
    /*public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char ch = board[i][j];
                if(ch == '.') continue;

                int box = (i/3)*3 + (j/3);
                if(rows[i].contains(ch) || cols[i].contains(ch) || boxes[box].contains(ch))
                    return false;

                rows[i].add(ch);
                cols[j].add(ch);
                boxes[box].add(ch);
            }
        }

        return true;
    }*/

    // Method 3: Using bitmask best
    public static boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char ch = board[i][j];
                if(ch == '.') continue;

                int digit = ch - '0';
                int mask = 1 << digit;
                int box = (i/3)*3 + (j/3);

                if((rows[i] & mask) != 0 || (cols[i] & mask) != 0 || (boxes[box] & mask) != 0)
                    return false;

                rows[i] |= mask;
                cols[j] |= mask;
                boxes[box] |= mask;
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

        System.out.println(isValidSudoku(board) ? "\nValid" : "\n0Invalid");
    }
}