package TwoDArray.ArraysTwoD;

import java.util.Scanner;

public class RotateSquareMatrix {
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
        System.out.print("Enter number of rows or columns iof square matrix: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + i + " , " + j + "): ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original array is: ");
        display(arr);

        //Rotation Logic
        //Step 1 - transpose
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //Step 2 - reverse the column order
        for (int i = 0; i < n; i++) {
            int startCol = 0, endCol = n -1;
            while(startCol < endCol){
                int temp = arr[i][startCol];
                arr[i][startCol] = arr[i][endCol];
                arr[i][endCol] = temp;
                startCol++;
                endCol--;
            }
        }

        System.out.println("Rotated Leetcode 48  matrix is: ");
        display(arr);
    }
}
