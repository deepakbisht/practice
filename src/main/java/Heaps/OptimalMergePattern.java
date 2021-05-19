package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created By Deepak Bisht on 25/04/21
 */
public class OptimalMergePattern {
    static PriorityQueue<Integer> integers = new PriorityQueue<>();

    public static void main(String[] args) {
        integers.addAll(Arrays.asList(20, 30, 40, 45, 50, 55));
        int maxRecordMovement = 0;
        while (integers.size()>1) {
            int sum = integers.poll() + integers.poll();
            integers.add(sum);
            System.out.println(sum);
            maxRecordMovement +=  sum;
        }
       // maxRecordMovement += integers.poll();
        System.out.println(maxRecordMovement);
    }
}
