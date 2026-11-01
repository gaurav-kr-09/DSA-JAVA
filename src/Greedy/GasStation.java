package Greedy;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // WRITE YOUR CODE HERE

        return -1;
    }

    public static void main(String[] args) {
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};

        System.out.println(canCompleteCircuit(gas1, cost1));
        // Expected: 3

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};

        System.out.println(canCompleteCircuit(gas2, cost2));
        // Expected: -1

        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};

        System.out.println(canCompleteCircuit(gas3, cost3));
        // Expected: 4

        int[] gas4 = {3, 3, 4};
        int[] cost4 = {3, 4, 4};

        System.out.println(canCompleteCircuit(gas4, cost4));
        // Expected: -1
    }
}