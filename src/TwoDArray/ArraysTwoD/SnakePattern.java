package TwoDArray.ArraysTwoD;

import java.util.Scanner;

public class SnakePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("(" + i + " , " + j + "): ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("The Original Array is:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("The matrix in snake pattern is:");
        for (int i = 0; i < arr.length; i++) {
            if(i %  2 == 0){
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }else {
                for (int j = arr[0].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }

            System.out.println();
        }
    }
}
