package QuickSort.QuickSelect;

import java.util.concurrent.ThreadLocalRandom;

public class KthLargestElement {
    // Older Method Using heap
    /*private static int kthSmallest(int[] arr, int k) {
        // Make a mean heap so that Kth largest remain on top
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: arr){
            pq.add(ele);
            if(pq.size() > k) pq.poll(); // pq.remove() -> safer
        }

        return pq.peek();
    }*/

    // New Method using QuickSelect

    // USING LOMUTO PARTITION
    /*private static int kthLargest(int[] arr, int k) {
        // since we are following 0 based indexing
        quickSelect(arr, 0, arr.length-1, k-1);
        return arr[k-1];
    }

    // Step 1. arrangement on appropriate side
    private static void quickSelect(int[] arr, int start, int end, int k){
        if(start >= end) return;

        int pi = partitionIdx(arr, start, end);
        if(pi == k) return;
        else if(pi > k) quickSelect(arr, start, pi-1, k);
        else quickSelect(arr, pi+1, end, k);
    }

    // Step 2. pivot k aage bada and equal, and pichhe chhota - by lomuto partition
    private static int partitionIdx(int[] arr, int start, int end) {
        // Making random pivot and taking it to end
        int pIdx = ThreadLocalRandom.current().nextInt(start, end+1);
        swap(arr, pIdx, end);
        int pivot = arr[end];

        // partitioning
        int l=start-1;
        for(int r = start; r < end; r++){
            if(arr[r] >= pivot){ // bada and equal pichhe chahiye - descending feel
                l++;
                swap(arr, r, l);
            }
        }

        // placing pivot to right place
        swap(arr, l+1, end);

        return l+1;
    }*/

    // USING HOARE'S PARTITION
    private static int kthLargest(int[] arr, int k) {
        int l=0, r=arr.length-1;

        while(true){
            int pi = partitionIdx(arr, l, r);
            if(pi == k-1) return arr[k-1]; // since 0-based indexing
            else if(pi < k-1) l = pi+1; // ex - pi= 3 and req $th largest
            else r = pi-1;
        }
    }

    private static int partitionIdx(int[] arr, int start, int end) {
        // Making random pivot and taking it to start
        int pIdx = ThreadLocalRandom.current().nextInt(start, end+1);
        swap(arr, pIdx, start);
        int pivot = arr[start];

        // partitioning
        //int l=start+1, r=end;
        //while(l <= r){
        //    if(arr[l] < pivot && arr[r] >= pivot){
        //        swap(arr, l, r);
        //        l++; r--;
        //    }
        //
        //    if(arr[l] >= pivot) l++;
        //    if(arr[r] < pivot) r--;
        //}

        // Partitioning - wo purana way
        int l=start+1, r=end;
        while(true){
            while (l <=r && arr[l] > pivot) l++;
            while (l <= r && arr[r] < pivot) r--;

            if(l > r) break;

            swap(arr, l, r);
            l++; r--;
        }

        swap(arr, start, r);
        return r;
    }

    // HELPER FUNCTION SWAP
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4; // ans = 4;

        System.out.println("Kth largest element in array is: " + kthLargest(arr, k));
    }
}