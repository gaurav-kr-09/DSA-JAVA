package Array.MissingQns;

public class MinJumpsToReachEndViaPrimeTeleportation {
    public static boolean isPrime(int n){
        if(n == 2 || n ==3) return true;
        if(n <= 1 || n % 2 == 0 || n % 3 == 0) return false;
        for(int i = 5; i*i <= n; i+= 6)
            if(n % i == 0 || n % (i+2) == 0) return false;

        return true;
    }

    public static int minJumps(int[] nums) {
        int n = nums.length;
        int i = 0, jumps = 0;
        while(i < n){
            if(!isPrime(nums[i])) i++;
            else{
                int j = n-1;
                boolean primeJump = false;
                while(j > i){
                    if(nums[j] % nums[i] == 0){
                        i = j;
                        primeJump = true;
                        break;
                    }
                    j--;
                }
                if(!primeJump) i++;
            };

            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,9}; // Ans: 2
        System.out.println("Minimum jumps to reach end is: "+ minJumps(arr));
    }
}
