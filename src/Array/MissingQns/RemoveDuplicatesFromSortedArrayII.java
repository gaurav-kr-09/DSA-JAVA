package Array.MissingQns;

public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int k=2;
        for(int i=2; i<n; i++){
            if(nums[i] != nums[i-2]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(arr);

        for(int i=0; i<k; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        int[] brr = {0,0,1,1,1,1,2,3,3};
        k = removeDuplicates(arr);

        for(int i=0; i<k; i++){
            System.out.print(arr[i] + " ");
        }
    }
}