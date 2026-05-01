package TwoDArray.ArraysTwoD;

import java.util.Scanner;

public class MinEleOutOfMaxEleInEachRow {
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

        int overAllMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < arr[0].length; j++) {
                if(max < arr[i][j]) max= arr[i][j];
            }
            if(max<overAllMin) overAllMin = max;
        }

        System.out.println("Minimum element out of all the maximum elements of each row is: "+ overAllMin);
    }
}
