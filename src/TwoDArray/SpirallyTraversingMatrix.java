package TwoDArray;

import java.util.Scanner;

public class SpirallyTraversingMatrix {
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

        System.out.println("The spirally traversed result is: ");
        //Main Logic of Traversing
        int fc = 0, fr = 0, lc = cols-1, lr = rows - 1;
        /*//Method 1
        while(fc <= lc && fr <= lr){
            for (int i = fc; i <= lc; i++) {
                System.out.print(arr[fr][i] + " ");
            }
            fr++;

            if(fr>lr || fc>lc) break;

            for (int i = fr; i <= lr; i++) {
                System.out.print(arr[i][lc] + " ");
            }
            lc--;

            if(fr>lr || fc>lc) break;

            for (int i = lc; i >= fc; i--) {
                System.out.print(arr[lr][i] + " ");
            }
            lr--;

            if(fr>lr || fc>lc) break;

            for (int i = lr; i >= fr; i--) {
                System.out.print(arr[i][fc] + " ");
            }
            fc++;
        }*/

        //Method 2
        int count = 0, totalElements = rows*cols;
        while(count < totalElements){
            for (int i = fc; i <= lc; i++) {
                System.out.print(arr[fr][i] + " ");
                count++;
            }
            fr++;

            if(count == totalElements) break;

            for (int i = fr; i <= lr; i++) {
                System.out.print(arr[i][lc] + " ");
                count++;
            }
            lc--;

            if(count == totalElements) break;

            for (int i = lc; i >= fc; i--) {
                System.out.print(arr[lr][i] + " ");
                count++;
            }
            lr--;

            if(count == totalElements) break;

            for (int i = lr; i >= fr; i--) {
                System.out.print(arr[i][fc] + " ");
                count++;
            }
            fc++;
        }
    }
}
