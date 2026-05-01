package BinarySearch;

import java.util.Scanner;

public class SearchInSortedMatrix {
    public static void display(int[][] arr, int r, int c) {
        for (int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The no. of row: ");
        int r = sc.nextInt();
        System.out.print("Enter The no. of column: ");
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Enter elements in array: ");
        for (int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++){
                System.out.print("( " + i +", "+ j + " ): ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original Array: ");
        display(arr, r, c);

        System.out.print("Enter The target to find: ");
        int target = sc.nextInt();

        boolean found = false;
        int low = 0, high = r*c-1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int midRow = mid / c;
            int midCol = mid % c;

            if(arr[midRow][midCol] == target){
                found = true;
                break;
            }

            if(arr[midRow][midCol] > target) high = mid  -1;
            else low = mid + 1;
        }

        System.out.println(found);
    }
}
