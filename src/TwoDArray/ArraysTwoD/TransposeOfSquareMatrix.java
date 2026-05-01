package TwoDArray.ArraysTwoD;

import java.util.Scanner;

public class TransposeOfSquareMatrix {
    public static void display(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows and columns for square matrix: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        System.out.println("Enter matrix elements: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("(" + i + " , " + j + "): ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("The Original matrix is:");
        display(arr);

        //Transpose logic
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        System.out.println("The transposed matrix is:");
        display(arr);
    }
}
