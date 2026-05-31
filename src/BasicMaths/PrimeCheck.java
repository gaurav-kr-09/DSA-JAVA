package BasicMaths;

public class PrimeCheck {
    // Good, tc -> O(root n)
    /*private static boolean checkPrime(int n) {
        if(n <= 1) return false;
        for(int i=2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }*/

    // Most efficient
    private static boolean checkPrime(int n) {
        if(n == 1) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;

        for(int i=5; i*i<=n; i+=6){
            if(n%i == 0 || n % (i+2) == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPrime(10)); // false
        System.out.println(checkPrime(11)); // true
        System.out.println(checkPrime(2)); // true
        System.out.println(checkPrime(13)); // true
        System.out.println(checkPrime(1)); // false
        System.out.println(checkPrime(36)); // false
        System.out.println(checkPrime(101)); // true
    }
}
