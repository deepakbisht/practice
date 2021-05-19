package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created By Deepak Bisht on 16/06/20
 */
public class MedianInStream {

    public static void printMedian(int[] arr) {
        double curr_median = 0;
        PriorityQueue<Integer> maxHeapLowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeapHigherHalf = new PriorityQueue();
        minHeapHigherHalf.add(arr[0]);
        curr_median = minHeapHigherHalf.peek();
        System.out.println("Median: " + curr_median);
        for (int i = 1; i < arr.length; i++) {
            if (maxHeapLowerHalf.size() > minHeapHigherHalf.size()) {
                if (arr[i] < curr_median) {
                    minHeapHigherHalf.add(maxHeapLowerHalf.poll());
                    maxHeapLowerHalf.add(arr[i]);
                } else {
                    minHeapHigherHalf.add(arr[i]);
                }
                curr_median = (minHeapHigherHalf.peek() + maxHeapLowerHalf.peek()) / 2;
                System.out.println("Median: " + curr_median);
            } else if (minHeapHigherHalf.size() > maxHeapLowerHalf.size()) {
                if (arr[i] > curr_median) {
                    maxHeapLowerHalf.add(minHeapHigherHalf.poll());
                    minHeapHigherHalf.add(arr[i]);
                } else {
                    maxHeapLowerHalf.add(arr[i]);
                }
                curr_median = (minHeapHigherHalf.peek() + maxHeapLowerHalf.peek()) / 2;
                System.out.println("Median: " + curr_median);
            } else {
                if (arr[i] < curr_median) {
                    maxHeapLowerHalf.add(arr[i]);
                    curr_median = maxHeapLowerHalf.peek();
                } else {
                    minHeapHigherHalf.add(arr[i]);
                    curr_median = minHeapHigherHalf.peek();
                }
                System.out.println("Median: " + curr_median);
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        printMedian(arr);
    }
}
