package BasicMaths;

public class PrintAllUniquePrimeFactors {
    //Method 1: Naive approach
    /*private static void printPrimeFactors(int n){
        for(int i=2; i*i<=n; i++){
            if(n % i == 0){
                int sec = n / i;
                if(isPrime(i)) System.out.print(i + " ");
                if(i != sec && isPrime(sec)) System.out.print(sec + " ");
            }
        }

        if(isPrime(n)) System.out.print(n + " ");
        System.out.println();
    }

    private static boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i=2; i*i <= n; i++){
            if(n % i == 0) return false;
        }

        return true;
    }*/

    //Method 2: best
    private static void printPrimeFactors(int n){
        for(int i=2; i*i<=n; i++){
            if(n % i == 0){
                System.out.print(i + " ");
                while(n % i == 0) n /= i;
            }
        }

        if(n != 1) System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printPrimeFactors(0); // null
        printPrimeFactors(1); // null
        printPrimeFactors(2); // 2
        printPrimeFactors(6); // 2,3
        printPrimeFactors(18); // 2,3
        printPrimeFactors(210); // 2,3,5,7
        printPrimeFactors(250); // 2,5
        printPrimeFactors(17); // 17
        printPrimeFactors(101); // 101
    }
}
