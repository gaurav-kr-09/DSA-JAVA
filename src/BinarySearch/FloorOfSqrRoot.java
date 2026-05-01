package BinarySearch;

import java.util.Scanner;

public class FloorOfSqrRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number: ");
        int n = sc.nextInt();

//        Brute Force.
        int i = 1;
        /*while((long)i * i <= n){
            i++;
        }
        int sqrt = i - 1;*/

//        Optimized
        int sqrt = 0;
        if(n < 2) sqrt = n;
        else{
            int low = 1, high = n / 2;

            while(low <= high){
                int mid = low + (high - low) /2;

                if((long)mid * mid > n){
                    high = mid -1;
                }else{
                    sqrt = mid;
                    low = mid + 1;
                }
            }
        }

        System.out.println("Square root floored is: "+ sqrt);
    }
}
