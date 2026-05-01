package BitManipulation;

public class NoOf1Bits {
    // method 1 bruteforce
    /*public static int hammingWeight(int n) {
        int count=0;
        for(int i=0; i < 31; i++){
            if(((n >> i) & 1) == 1) count ++;
        }
        return count;
    }*/

    // Method 2- Tc same Kernighan's Algorithm.
    public static int hammingWeight(int n) {
        int count=0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(1)); // 1
        System.out.println(hammingWeight(0)); // 0
        System.out.println(hammingWeight(2)); // 1
        System.out.println(hammingWeight(7)); // 3
        System.out.println(hammingWeight(16)); // 1
        System.out.println(hammingWeight(15)); // 4
    }
}