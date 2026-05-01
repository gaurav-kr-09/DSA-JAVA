package BitManipulation;

public class XorOfNosInGivenRange {
    // Method 1: Bruteforce
    /*public static int findXOR(int l, int r){
        int ans = 0;
        for(int i = l; i<=r; i++) ans ^= i;
        return ans;
    }*/

    // Method 2: optimal based on observations in notebook
    public static int findXOR(int l, int r) {
        // (1^2^3^4^5^6^7^8)  ^ (1^2^3) = 4^5^6^7^8
        if (l == 0) return xor(r);
        return xor(r) ^ xor(l-1);
    }

    public static int xor(int n){
        if(n % 4 == 1) return 1;
        else if(n % 4 == 2) return n+1;
        else if(n % 4 == 3) return 0;
        else return n;
    }

    public static void main(String[] args) {
        System.out.println(findXOR(4,8)); // 8
        System.out.println(findXOR(2,4)); // 5
        System.out.println(findXOR(5,9)); // 5
    }
}
