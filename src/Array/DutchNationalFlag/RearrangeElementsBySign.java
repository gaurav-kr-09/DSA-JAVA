package Array.DutchNationalFlag;

public class RearrangeElementsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int pos = 0, neg = 1;
        for(int num: nums){
            if(num > 0) {
                ans[pos] = num;
                pos += 2;
            }else{
                ans[neg] = num;
                neg += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};  // ANS -> 3,-2,1,-5,2,-4
        int[] ans = rearrangeArray(arr);
        for(int a: ans) System.out.print(a + " ");
    }
}