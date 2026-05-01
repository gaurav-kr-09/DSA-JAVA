package BitManipulation;

public class XorInAnArray {
    // Bruteforce
    public static int xorOperation(int n, int start) {
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans ^= (start + 2 * i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0)); // 8
        System.out.println(xorOperation(4, 3)); // 8
    }
}