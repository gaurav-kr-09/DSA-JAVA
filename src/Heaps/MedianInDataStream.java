package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInDataStream {
    // BruteForce  - will give TLE
    /*static class MedianFinder {
        ArrayList<Integer> arr;
        public MedianFinder() {
            arr = new ArrayList<>();
        }

        public void addNum(int num) {
            arr.add(num);
        }

        public double findMedian() {
            Collections.sort(arr);
            int n = arr.size();
            if(n % 2 != 0) return arr.get(n/2);
            else return (arr.get(n/2) + arr.get(n/2-1)) / 2.0;
        }
    }*/

    // Bruteforce little bit optimized
    /*static class MedianFinder {
        ArrayList<Integer> arr;
        public MedianFinder() {
            arr = new ArrayList<>();
        }

        public void addNum(int num) {
            int i = 0;
            while(i < arr.size() && arr.get(i) < num) i++;
            arr.add(i, num);
        }

        public double findMedian() {
            int n = arr.size();
            if(n % 2 != 0) return arr.get(n/2);
            else return (arr.get(n/2) + arr.get(n/2-1)) / 2.0;
        }
    }*/

    // optimal
    static class MedianFinder {
        PriorityQueue<Integer> maxHeap; // to store elements smaller than median
        PriorityQueue<Integer> minHeap; // to store elements larger than median

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(maxHeap.isEmpty()) maxHeap.add(num);
            else{
                if(num < maxHeap.peek()) maxHeap.add(num);
                else minHeap.add(num);
            }
            if(maxHeap.size() == minHeap.size() + 2) minHeap.add(maxHeap.remove());
            else if(minHeap.size() == maxHeap.size() + 2) maxHeap.add(minHeap.remove());
        }

        public double findMedian() {
            if(maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek()) / 2.0;
            else if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
            else return minHeap.peek();
        }
    }

    public static void main(String[] args) {

    }
}