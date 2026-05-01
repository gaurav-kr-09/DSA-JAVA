package TwoDArray;

import java.util.Scanner;

public class MultiplyMatrices {
    public static void display(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void scan(int[][] arr){
        System.out.println("Enter array elements: ");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("(" + i + " , " + j + "): ");
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows of first matrix: ");
        int rows1 = sc.nextInt();
        System.out.print("Enter number of columns of first matrix which will also be rows of second matrix: ");
        int cols1 = sc.nextInt();
        int[][] arr = new int[rows1][cols1];
        scan(arr);
        System.out.println("The Original first Array is:");
        display(arr);

        System.out.print("Enter number of columns of second matrix: ");
        int cols2 = sc.nextInt();
        int[][] brr = new int[cols1][cols2];
        scan(brr);
        System.out.println("The Original second Array is:");
        display(brr);

        int[][] res = new int[rows1][cols2];
        //Multiplying logic
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    res[i][j] += arr[i][k] * brr[k][j];
                }
            }
        }

        System.out.println("The resulting multiplied Array is:");
        display(res);
    }
}
