package BasicMaths;

public class SquareRoot {
    // Binary search
    private static double sqrt(int n, int p){
        int lo = 0, hi = n;

        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(mid * mid == n) return mid; // perfect decimal
            else if(mid * mid > n) hi = mid - 1;
            else lo = mid + 1;
        }

        double root = hi;
        double incr = 0.1;
        for(int i=0; i<p; i++){
            while (root * root <= n) root += incr;
            root -= incr; // overflow
            incr /= 10; // fo
        }
        return root;
    }

    public static void main(String[] args) {
        int p = 3; // precision digits we want
        System.out.println(sqrt(36, p));
        System.out.println(sqrt(25, p));
        System.out.println(sqrt(40, p));
        System.out.println(sqrt(12, p));
    }
}
