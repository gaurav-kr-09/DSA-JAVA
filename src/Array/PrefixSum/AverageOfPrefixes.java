package Array.PrefixSum;

public class AverageOfPrefixes {
    // OPTIMAL
    /*public static int[] prefixAvg(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        int pre = 0;
        for(int i=0; i<n; i++){
            pre += arr[i];
            ans[i] = (pre / (i+1));
        }

        return ans;
    }*/

    // SAME IDEA BUT ONE MORE WAY
    public static int[] prefixAvg(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++){
            arr[i] += arr[i-1];
        }

        for(int i=0; i<n; i++){
            arr[i] /= (i+1);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50}; // 10 15 20 25 30
        int[] ans = prefixAvg(arr);

        for(int num: ans) System.out.print(num + " ");
    }
}
