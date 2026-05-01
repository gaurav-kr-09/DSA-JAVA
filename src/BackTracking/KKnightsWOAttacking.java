package BackTracking;

public class KKnightsWOAttacking {
    // Method 1
    /*public static int[][] dir = {
        {-2, 1}, {-2, -1},
        {2, 1}, {2, -1},
        {1, 2}, {-1, 2},
        {1, -2}, {-1, -2}
    };

    public static boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        for(int[] d: dir){
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n && board[nr][nc] == 'K')
                return false;
        }
        return true;
    }

    public static int count=0;
    public static void fillKnights(char[][] board, int row, int col, int num, int knights){
        int n = board.length;
        if(row == n){
            if(num == knights){
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++) System.out.print(board[i][j] + " ");
                    System.out.println();
                }
                System.out.println(count++);
            }
            return;
        }
        else if(isSafe(board, row, col)){
            board[row][col] = 'K';
            if(col != n-1) fillKnights(board, row, col+1, num+1, knights);
            else fillKnights(board, row+1, 0, num+1, knights);
            board[row][col] = 'X';
        }

        if(col != n-1) fillKnights(board, row, col+1, num, knights);
        else fillKnights(board, row+1, 0, num, knights);
    }*/

    // Method 2: similar but little optimized
    // niche check karne ka jarurat nhi hai
    public static int[][] dir = {
            {-2, 1}, {-2, -1},
            {-1, 2}, {-1, -2}
    };

    public static boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        for(int[] d: dir){
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n && board[nr][nc] == 'K')
                return false;
        }
        return true;
    }

    public static int count=0;
    public static void fillKnights(char[][] board, int row, int col, int num, int knights){
        int n = board.length;
        if(row == n){
            if(num == knights){
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++) System.out.print(board[i][j] + " ");
                    System.out.println();
                }
                System.out.println(count++);
            }
            return;
        }
        else if(isSafe(board, row, col)){
            board[row][col] = 'K';
            if(col != n-1) fillKnights(board, row, col+1, num+1, knights);
            else fillKnights(board, row+1, 0, num+1, knights);
            board[row][col] = 'X';
        }

        if(col != n-1) fillKnights(board, row, col+1, num, knights);
        else fillKnights(board, row+1, 0, num, knights);
    }

    public static void main(String[] args) {
        int n = 3;
        int knights = 5;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) board[i][j] = 'X';
        }
        fillKnights(board, 0, 0, 0, knights);
    }
}