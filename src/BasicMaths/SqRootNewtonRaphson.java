package BasicMaths;

public class SqRootNewtonRaphson {
    private static double sqrt(int n){
        double x = n;

        double root;
        while (true){
            root = 0.5 * (x + (n/x));

            if(Math.abs(root - x) < 1e-6) break;

            x=root;
        }

        return root;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(36));
        System.out.println(sqrt(25));
        System.out.println(sqrt(40));
        System.out.println(sqrt(12));
    }
}
