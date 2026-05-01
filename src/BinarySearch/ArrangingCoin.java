package BinarySearch;

import java.util.Scanner;

public class ArrangingCoin {
    public static int findRoot(int n){
        if(n < 2) return n;
        int low = 1, high = n/2, sqrt = -1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if((long)mid * mid > n) high = mid - 1;
            else{
                sqrt = mid;
                low = mid + 1;
            }
        }
        return sqrt;
    }

    public static int findStairs(int n){
        //Method 1 inBuilt square root use kar k
//        return (int)(Math.sqrt(8*n+1) - 1)/2;

        //Method 2 Khud se floor of square root likh k
//        return (findRoot(8*n+1) - 1)/2;

        //Method 3 using binary search
        int low = 0, high = n, ans = 0;

        while(low <= high){
            int mid = low + (high - low) /2;
            int m = mid * (mid + 1) /2;

            if(m == n) return mid;

            if(m > n) high = mid -1;
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The no. of coins: ");
        int n = sc.nextInt();

        System.out.println("No. of stairs: ");
        System.out.println(findStairs(n));
    }
}
