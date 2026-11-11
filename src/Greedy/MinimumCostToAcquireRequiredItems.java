package Greedy;

public class MinimumCostToAcquireRequiredItems {
    public static long minimumCost(int c1, int c2, int cb,
                                   int n1, int n2) {
        // alag alag sasta pad rha hai
        if(c1 + c2 <= cb) return (1L * n1 * c1) + (1L * n2 * c2);

        // both wala sasta pad rha hai
        int min = Math.min(n1, n2);
        long total = 1L * min * cb;

        if(n1 > min) return total + (1L * (n1 - min) * Math.min(c1, cb));
        return total + (1L * (n2 - min) * Math.min(c2, cb));
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {3, 2, 1, 3, 2},
                {5, 4, 15, 2, 3},
                {5, 4, 15, 0, 0},
                {2, 3, 4, 5, 2},
                {5, 2, 3, 2, 5},
                {1, 1, 5, 10, 10}
        };

        long[] expected = {
                3L,
                22L,
                0L,
                14L,
                12L,
                20L
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] t = testCases[i];

            long result = minimumCost(t[0], t[1], t[2], t[3], t[4]);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Expected: " + expected[i]);
            System.out.println("Actual:   " + result);
            System.out.println("Status:   " +
                    (result == expected[i] ? "PASS" : "FAIL"));
            System.out.println();
        }
    }
}