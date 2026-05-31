package BasicMaths;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindingMedianOfXSizedSubArray {
    // Method 1: BRUTE FORCE Will give TLE (O(n-x+1) * (xLogx))
    /*private static double[] findMedian(int[] arr, int x) {
        int n = arr.length;
        double[] ans = new double[n-x+1];

        boolean even = (x % 2 == 0);

        for (int i=0; i<n-x+1; i++){
            int[] temp = new int[x];
            for(int j=0; j < x; j++) temp[j] = arr[i+j];

            Arrays.sort(temp);

            if(!even) ans[i] = temp[x/2];
            else ans[i] = ((double)temp[x/2] + temp[x/2 - 1]) / 2.0;
        }

        return ans;
    }*/

    // Slightly better but still TlE
    private static double[] findMedian(int[] arr, int x) {
        int n = arr.length;
        double[] ans = new double[n-x+1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<x; i++) heapAdd(arr[i], maxHeap, minHeap);

        boolean even = (x%2 == 0);
        int k = 0;
        if(even) ans[k++] = ((double)maxHeap.peek() + minHeap.peek()) / 2.0;
        else ans[k++] = maxHeap.peek();

        for(int i=x; i<n; i++){
            heapDelete(arr[i-x], maxHeap, minHeap);
            heapAdd(arr[i], maxHeap, minHeap);

            if(even) ans[k++] = ((double)maxHeap.peek() + minHeap.peek()) / 2.0;
            else ans[k++] = maxHeap.peek();
        }

        return ans;
    }

    private static void heapAdd(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        if (maxHeap.isEmpty()) maxHeap.add(num);
        else{
            if(num <= maxHeap.peek()) maxHeap.add(num);
            else minHeap.add(num);
        }

        balanceHeaps(maxHeap, minHeap);
    }

    private static void heapDelete(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        boolean dltMax = maxHeap.remove(num);
        if(!dltMax) minHeap.remove(num);

        balanceHeaps(maxHeap, minHeap);
    }

    private static void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        while (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
        while (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
    }

    public static void main(String[] args) {
        int[] arr = {5, -2, 1, 3, 7, 3, 6, 4, -1};
        int x = 5; // 3.0 3.0 3.0 4.0 4.0
        double[] ans = findMedian(arr, x);
        for(double a: ans) System.out.print(a + " ");
    }
}
