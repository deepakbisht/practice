package Heaps;

/**
 * Created By Deepak Bisht on 18/06/20
 */
public class HeapSort {

    public static void buildHeap(int[] arr) {
        for (int i = (arr.length / 2 - 1); i >= 0; i--) {
            minHeapify(arr, i);
        }
        System.out.println(arr);
    }

    public static void minHeapify(int arr[], int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < arr.length && arr[left] < arr[largest]) {
            largest = left;
        }
        if (right < arr.length && arr[right] < arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            minHeapify(arr, largest);
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        buildHeap(arr);
    }
}
