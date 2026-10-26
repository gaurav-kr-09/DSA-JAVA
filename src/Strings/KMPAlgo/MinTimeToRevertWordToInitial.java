package Strings.KMPAlgo;

// leetcode 3029 and 3031 same hi hai bas constraints ka difference hai
// 3031 wala hard hai so more tight constraint
public class MinTimeToRevertWordToInitial {
    // Ye soln o(nsq) medium wale pe kam kar jayega
    // but hard wale pe nahi kam karega
    /*public static int minimumTimeToInitialState(String word, int k) {
        int n = word.length();

        int count = 1;
        int i = k;

        while(i < n){
            if(word.substring(i, n).equals(word.substring(0, n-i)))
                return count;
            else{
                i += k;
                count++;
            }
        }

        // return count;
        // iski jagah ye v return kar sakte hai jab pura string hi
        // k steps me delete karna pad jaye
        // return (int) Math.ceil(n / (k * 1.0)); // 1.0 se guna double banane ko
        // and ye v kar sakte ceiling ko
        return (n+k-1) / k;
    }*/

    public static int minimumTimeToInitialState(String word, int k) {
        int n = word.length();

        int[] lps = computeLPS(word);
        int lenOfSuff = lps[n-1]; // length of suffix

        while(lenOfSuff > 0 && (n - lenOfSuff) % k != 0)
            lenOfSuff = lps[lenOfSuff - 1];

        if(lenOfSuff == 0) return (n+k-1) / k; // (int) Math.ceil(n / (k * 1.0));

        return (n-lenOfSuff) / k; // divisible ho gaya
    }

    public static int[] computeLPS(String patt) {
        int m = patt.length();
        int[] LPS = new int[m];

        int len = 0;
        LPS[0] = 0;

        int i = 1;
        while (i < m){
            if(patt.charAt(i) == patt.charAt(len)){
                len++;
                LPS[i++] = len;
            }else{
                if(len != 0) len = LPS[len-1];
                else LPS[i++] = 0;
            }
        }

        return LPS;
    }

    public static void main(String[] args) {

        String word1 = "abacaba";
        int k1 = 3;
        System.out.println(minimumTimeToInitialState(word1, k1)); // Expected: 2

        String word2 = "abacaba";
        int k2 = 4;
        System.out.println(minimumTimeToInitialState(word2, k2)); // Expected: 1

        String word3 = "abcbabcd";
        int k3 = 2;
        System.out.println(minimumTimeToInitialState(word3, k3)); // Expected: 4

        String word4 = "a";
        int k4 = 1;
        System.out.println(minimumTimeToInitialState(word4, k4)); // Expected: 1

        String word5 = "aaaa";
        int k5 = 2;
        System.out.println(minimumTimeToInitialState(word5, k5)); // Expected: 1

        String word6 = "abcde";
        int k6 = 2;
        System.out.println(minimumTimeToInitialState(word6, k6)); // Expected: 3
    }
}