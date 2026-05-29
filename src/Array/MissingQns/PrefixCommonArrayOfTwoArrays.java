package Array.MissingQns;

public class PrefixCommonArrayOfTwoArrays {
    // BRUTEFORCE TC O(NSQ) SC O(N)
    /*public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();

        int n = A.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int count = 0;
            aSet.add(A[i]); bSet.add(B[i]);

            for(int num: aSet){
                if(bSet.contains(num)) count++;
            }

            ans[i] = count;
        }

        return ans;
    }*/

    // OPTIMAL TC O(N) SC(O(N))
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        int[] freq = new int[n+1];
        int common = 0;

        for(int i=0; i<n; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2) common++; // Matlab dono me aa chuka hai

            freq[B[i]]++;
            if(freq[B[i]] == 2) common++; // Matlab dono me aa chuka hai

            ans[i] = common;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4}, brr = {3,1,2,4};
        int[] ans = findThePrefixCommonArray(arr, brr);
        for(int i: ans) System.out.print(i + " ");
    }
}