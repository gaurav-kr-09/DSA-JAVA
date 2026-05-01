package BitManipulation;

public class IsPowerOf4 {
    // m-1 iterative
    /*public static boolean isPowerOfFour(int n) {
        return n > 0 && isPowerOfTwo(n) && isPerfectSquare(n);
    }

    private static boolean isPerfectSquare(int n) {
        int sqr = (int) Math.sqrt(n);
        return n == sqr * sqr;
    }

    private static boolean isPowerOfTwo(int n) {
        return ((n & (n-1)) == 0);
    }*/

    // m-2: recursive
    /*public static boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        if(n % 4 != 0) return false;
        return isPowerOfFour(n/4);
    }*/

    // m-3 pure bit manipulation
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n-1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(0)); // false
        System.out.println(isPowerOfFour(1)); // true
        System.out.println(isPowerOfFour(4)); // true
        System.out.println(isPowerOfFour(32)); // false
        System.out.println(isPowerOfFour(15)); // false
        System.out.println(isPowerOfFour(64)); // true
        System.out.println(isPowerOfFour(-16)); // false
    }
}
