package Heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created By Deepak Bisht on 03/07/20
 */
public class KthLargestInStream {

    public static void printKthLargest(int []arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() == k) {
                if (pq.peek() < arr[i]) {
                    pq.poll();
                    pq.add(arr[i]);
                }
                System.out.print(pq.peek() + " ");
            } else {
                pq.add(arr[i]);
                if (pq.size() < k) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(pq.peek() + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n != 0) {
            int k = s.nextInt();
            int size = s.nextInt();
            int[] arr = new int[size];
            int i = 0;
            while (i < size) {
                arr[i] = s.nextInt();
                i++;
            }
            printKthLargest(arr, k);
            n--;
        }
    }
}
