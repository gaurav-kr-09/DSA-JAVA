package Array;

public class ShiftingLetters {
    // BruteForce O(nsq)
    /*public static String shiftingLetters(String s, int[] shifts) {
        char[] temp = s.toCharArray();

        for(int i=0; i<s.length(); i++){
            for(int j=0; j<=i; j++){
                int curr = temp[j] - 'a';
                curr = (curr + shifts[i]) % 26;
                temp[j] = (char)(curr + 'a');
            }
        }

        return new String(temp);
    }*/

    // Optimal - O(n)
    public static String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] temp = s.toCharArray();

        int totalShift = 0;
        for(int i=n-1; i>=0; i--){
            totalShift = (totalShift + shifts[i]) % 26;  //% 26 to avoid integer overflow

            int curr = temp[i] - 'a';
            curr = (curr + totalShift) % 26;
            temp[i] = (char)(curr + 'a');
        }

        return new String(temp);
    }

    public static void main(String[] args) {
        int[] shifts = {1, 2, 3};
        String s = "aaa"; // gfd
        System.out.println(shiftingLetters(s, shifts));

        int[] shifts2 = {3, 5, 9};
        String s2 = "abc"; // rpl
        System.out.println(shiftingLetters(s2, shifts2));
    }
}