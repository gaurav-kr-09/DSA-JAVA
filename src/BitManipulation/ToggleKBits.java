package BitManipulation;

public class ToggleKBits {
    // O(r-l)
    /*static int toggleBits(int n, int l, int r) {
        for(int i = l-1; i <= r-1; i++){
            n = n ^ (1 << i);
        }
        return n;
    }*/

    // O(1)
    static int toggleBits(int n, int l, int r) {
        int mask = ((1 << (r-l+1)) - 1) << (l-1);
        return n ^ mask;
    }

    public static void main(String[] args) {
        System.out.println(toggleBits(17, 2, 3)); // ans 23
    }
}