package Greedy;

public class GasStation {
    // BruteForce
    /*public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for(int i=0; i<n; i++){
            // i wale ko to inner loop k bahar hi dekh liye
            if(gas[i] < cost[i]) continue; // gas cost se kam to aage badho
            int j = (i+1)%n; // j ko circular aage badhaye
            // currGas = (is stn ka gas) - (yaha jo kharch hoga) + (jaha ja rhe hai uska)
            // jaha ja rhe hai uska v jod liye taki loop ka kam sahi se ho jaye
            int currGas = gas[i] - cost[i] + gas[j];
            // aab i se aage wale ko dekh rhe hai
            while(j != i){
                if(currGas < cost[j]) break; // agar gas kam to bahar
                currGas -= cost[j]; // abhi wala cost minus
                j = (j+1) % n; // j ko circular aage badhaye
                currGas += gas[j]; // jaha ja rhe hai uska jode
            }
            if(j == i) return i;
        }

        return -1;
    }*/

    // ye v bruteforce hi hai but more redable
    /*public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for(int i=0; i<n; i++){
            if(gas[i] < cost[i]) continue;
            int j = (i+1)%n;
            int currGas = gas[i] - cost[i];
            while(j != i){
                currGas += gas[j];
                if(currGas < cost[j]) break;
                currGas -= cost[j];
                j = (j+1) % n;
            }
            if(j == i) return i;
        }

        return -1;
    }*/

    // optimal solution
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0, totalCost = 0;
        for(int g: gas) totalGas += g;
        for(int c: cost) totalCost += c;

        if(totalCost > totalGas) return -1; // impossible

        int ans = 0;
        int currGas = 0;
        for(int i=0; i<n; i++){
            currGas += (gas[i] - cost[i]);
            if(currGas < 0){
                ans = i + 1;
                currGas = 0;
            }
        }

        return ans;
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