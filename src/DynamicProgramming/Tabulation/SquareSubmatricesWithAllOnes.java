package DynamicProgramming.Tabulation;

public class SquareSubmatricesWithAllOnes {
    public static int countSquares(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // filling internal cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] != 0)
                    mat[i][j] = 1 + Math.min(mat[i - 1][j - 1], Math.min(mat[i - 1][j], mat[i][j - 1]));
            }
        }

        // getting answer
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                ans += mat[i][j];
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        })); // 15

        System.out.println(countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        })); // 7

        System.out.println(countSquares(new int[][]{
                {1}
        })); // 1

        System.out.println(countSquares(new int[][]{
                {0}
        })); // 0

        System.out.println(countSquares(new int[][]{
                {1, 1},
                {1, 1}
        })); // 5

        System.out.println(countSquares(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        })); // 14
    }
}