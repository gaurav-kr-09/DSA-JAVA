package BasicMaths;

public class PrintAllPrimeFactors {
    private static void printPrimeFactors(int n){
        for(int i=2; i*i<=n; i++){
            while(n % i == 0){
                System.out.print(i + " ");
                n /= i;
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
        printPrimeFactors(18); // 2,3,3
        printPrimeFactors(210); // 2,3,5,7,
        printPrimeFactors(250); // 2,5,5,5
        printPrimeFactors(17); // 17
        printPrimeFactors(101); // 101
    }
}