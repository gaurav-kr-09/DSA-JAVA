package Array.DifferenceArray;

public class ShiftingLetters2 {
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();

        // make difference array for queries
        int[] diff = new int[n];
        for(int[] shift: shifts){
            int inc = shift[2] == 0 ? -1 : 1;
            diff[shift[0]] += inc;
            if(shift[1] + 1 < n) diff[shift[1] + 1] -= inc;
        }

        // prefix sum on diff array
        for(int i=1; i<n; i++) diff[i] += diff[i-1];

        // shifting each char in string
        char[] temp = s.toCharArray();
        for(int i=0; i<n; i++){
            int curr = temp[i] - 'a';
            curr = ((curr + diff[i]) % 26 + 26) % 26; // to avoid -ve indices
            temp[i] = (char)(curr + 'a');
        }

        return new String(temp);
    }

    public static void main(String[] args) {
        String s = "dztz"; // "catz"
        int[][] shifts = {{0,0,0},{1,1,1}};
        System.out.println(shiftingLetters(s, shifts));

        String s2 = "abc"; // "ace"
        int[][] shifts2 = {{0,1,0},{1,2,1},{0,2,1}};
        System.out.println(shiftingLetters(s2, shifts2));
    }
}