package CountBucketRadixSort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    private static void bucketSort(float[] arr){
        int n = arr.length;
        // making n buckets
        ArrayList<Float>[] buckets = new ArrayList[n];

        // initializing each bucket
        for(int i=0; i<n; i++) buckets[i] = new ArrayList<Float>();

        // adding elements into buckets
        for(int i=0; i<n; i++) {
            int bucketIndex = (int) (arr[i] * n);
            buckets[bucketIndex].add(arr[i]);
        }

        // Sorting each buckets individually
        for(ArrayList<Float> bucket: buckets){
            Collections.sort(bucket);
        }

        // merging each bucket
        int idx = 0;
        for(ArrayList<Float> bucket: buckets){
            for(int i=0; i< bucket.size(); i++){
                arr[idx++] = bucket.get(i);
            }
        }
    }

    private static void display(float[] arr){
        for(float f : arr){
            System.out.print(f + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        float[] arr = {0.4f, 0.5f, 0.3f, 0.2f, 0.1f};
        System.out.print("Original array is: ");
        display(arr);

        bucketSort(arr);

        System.out.print("Sorted array is: ");
        display(arr);
    }
}
