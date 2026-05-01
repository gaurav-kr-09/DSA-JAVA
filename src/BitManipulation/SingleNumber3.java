package BitManipulation;

public class SingleNumber3 {
    // Method 1: Bruteforce
    /*public static int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }

        int[] ans = new int[2];
        int i = 0;
        for(int n: set) ans[i++]=  n;

        return ans;
    }*/

    // Method 2:  Optimal
    public static int[] singleNumber(int[] arr) {
        int xor = 0;
        for(int n: arr) xor ^= n;

        // int mask = xor & -xor;
        // WE CAN ALSO USE
        int mask = ((xor & xor-1) ^ xor);

        int a = 0, b = 0; // a 0 wale k liye and b non zero
        for(int n: arr){
            if((n & mask) == 0) a ^= n;
            else b ^= n;
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] arr = singleNumber(new int[]{3,4,3,2,4,6,8,9,2,8}); // 6, 9
        System.out.println("Two single nos. in array are: " + arr[0] + " & " + arr[1]);
    }
}