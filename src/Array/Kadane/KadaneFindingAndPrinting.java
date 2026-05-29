package Array.Kadane;

public class KadaneFindingAndPrinting {
    private static int[] kadanePrint(int[] arr){
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        int tempStart = 0, start = 0, end = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > arr[i]+currSum){ // new subarray start
                currSum = arr[i];
                tempStart = i;
            }else{ // old subArray continue
                currSum += arr[i];
            }

            if(currSum > maxSum){
                maxSum = currSum;
                start = tempStart;
                end = i; // at that moment, the best subarray found so far ends at the current index i.
            }
        }

        return new int[]{maxSum, start, end};
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3}; // ans = 7 ->  4, -1, -2, 1, 5

        int[] ans = kadanePrint(arr);

        System.out.println("Maximum sum: " + ans[0]);
        System.out.println("Start index: " + ans[1]);
        System.out.println("End index: " + ans[2]);

        System.out.print("Subarray: ");

        for (int i = ans[1]; i <= ans[2]; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
