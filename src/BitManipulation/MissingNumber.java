package BitManipulation;

public class MissingNumber {
    public static int missingNumber(int[] arr) {
        int ans = 0;
        for(int i = 1; i <= arr.length; i++){
            ans ^= i;
            ans ^= arr[i-1];
        }
        
//        int ans=arr.length;
//        for(int i = 0; i < arr.length; i++){
//            ans ^= i ^ arr[i];
//        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("The missing number in array is: " + missingNumber(new int[]{0,3,1})); // 2
        System.out.println("The missing number in array is: " + missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8
    }
}
