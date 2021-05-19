package StackAndQueue;

/**
 * Created By Deepak Bisht on 02/06/20
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Sliding Window Maximum (Maximum of all subarrays of size k)
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 * Examples :
 *
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 *
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 * Explanation:
 * Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e from index 1 to 4) is 10, So the sequence
 * generated is 10 10 10 15 15 90 90
 *
 * Solution 1:  AVL
 * Solution 2: HEAP
 * Solution 3: DEQUEU
 */
public class MaxInSubArray {


    public static void printMax(int arr[], int k) {
        Deque<Integer> deque = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }

        for (; i < arr.length; i++) {
            System.out.print(arr[deque.peekFirst()] + " ");

            while (!deque.isEmpty() && deque.peek() <= (i - k))
                deque.removeFirst();

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();

            deque.add(i);
        }
        System.out.print(arr[deque.peekFirst()]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfCases = input.nextInt();
        while(numberOfCases !=0) {
            int[] arr = new int[input.nextInt()];
            int k = input.nextInt();
            int i = 0;
            while (i < arr.length) {
                arr[i] = input.nextInt();
                i++;
            }
            printMax(arr, k);
            numberOfCases--;
            System.out.println();
        }
    }
}
