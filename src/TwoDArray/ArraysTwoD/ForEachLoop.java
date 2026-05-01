package TwoDArray.ArraysTwoD;

import java.util.Scanner;

public class ForEachLoop {
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

        System.out.println("The Original Array printed using inner foreach loop:");
        for (int i = 0; i < arr.length; i++) {
            for (int ele: arr[i]) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("The Original Array printed using both for each loop:");
        for (int[] a: arr) {
            for (int ele: a) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
