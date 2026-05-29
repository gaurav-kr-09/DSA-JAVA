package CountBucketRadixSort;

public class SortedExceptTwo {
    private static void fullySorted(int[] arr){
        if(arr.length <= 1) return;
        int x=-1, y=-1;
        for (int i=0; i< arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                y = i+1;
                if(x == -1) x = i;
            }
        }

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,6,7,5,9,10};
        fullySorted(arr);
        for(int a: arr) System.out.print(a + " ");
    }
}
