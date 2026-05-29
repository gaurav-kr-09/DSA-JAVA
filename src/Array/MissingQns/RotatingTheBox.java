package Array.MissingQns;

import java.util.Arrays;

public class RotatingTheBox {
    // Method 1: optimal
    /*public static char[][] rotateTheBox(char[][] boxGrid) {
        int row = boxGrid.length, col = boxGrid[0].length;

        // Step 1: apply gravity (stones fall to the right)
        for (int i = 0; i < row; i++) {
            int empty = col-1;
            for (int j=col-1; j >= 0; j--) {
               if(boxGrid[i][j] == '*') empty = j-1;
               else if(boxGrid[i][j] == '#'){
                   char temp = boxGrid[i][empty];
                   boxGrid[i][empty] = '#';
                   boxGrid[i][j] = temp;
                   empty--;
               }
            }
        }

        // step 2: rotate 90 deg clockwise
        char[][] ans = new char[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][row-i-1] = boxGrid[i][j];
            }
        }

        return ans;
    }*/

    // Method 2: optimal but better
    public static char[][] rotateTheBox(char[][] boxGrid) {
        int row = boxGrid.length, col = boxGrid[0].length;
        char[][] ans = new char[col][row];
        for(char[] ch: ans) Arrays.fill(ch, '.');

        // Step 1: apply gravity (stones fall to the right)
        for (int i = 0; i < row; i++) {
            int empty = col-1;
            for (int j=col-1; j >= 0; j--) {
                if(boxGrid[i][j] == '*'){
                    ans[j][row-i-1] = '*';
                    empty = j-1;
                }else if(boxGrid[i][j] == '#'){
                    ans[empty][row-i-1] = '#';
                    empty--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}};

        for(char[] gr: grid){
            for(char g: gr) System.out.print(g + " ");
            System.out.println();
        }

        System.out.println("++++++++++++++++++");

        char[][] ans = rotateTheBox(grid);
        for(char[] an : ans){
            for(char a : an) System.out.print(a + " ");
            System.out.println();
        }
    }
}
