package BitManipulation;

public class IsNPowerOf2 {
    // Brute force O(log n) both space and time
    /*public static boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        if((n & 1) == 1) return false; // odd no.
        return isPowerOfTwo(n/2);
    }*/

    // O(1) best
    public static boolean isPowerOfTwo(int n){
        return n > 0 && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(24)); // false
        System.out.println(isPowerOfTwo(64)); // true
        System.out.println(isPowerOfTwo(-1)); // false
        System.out.println(isPowerOfTwo(1)); // true
        System.out.println(isPowerOfTwo(0)); // false
    }
}