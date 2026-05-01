package BitManipulation;

public class SingleNumber2 {
    // BruteForce
    /*public static int singleNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int n: map.keySet()) if(map.get(n) < 3) return n;

        return -1;
    }*/

    //  Not optimal but okay
    /*public static int singleNumber(int[] arr) {
        int ans = 0;
        for(int i=0; i<32; i++){
            int mask = 1 << i;
            int ones = 0;
            for(int n: arr){
                if((n & mask) != 0) ones++;
            }

            if(ones % 3 == 1) ans |= mask;
        }

        return ans;
    }*/

    // best
    public static int singleNumber(int[] arr) {
        int ones=0, twos=0;
        for(int n: arr){
            ones = (ones ^ n) & ~twos;
            twos = (twos ^ n) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,1,99}; // 99 ans
        int[] brr = {2,3,2,2,5,1,1,1,5,5}; // 3 ans
        System.out.println("Single no. in array arr is: " + singleNumber(arr));
        System.out.println("Single no. in array brr is: " + singleNumber(brr));
    }
}