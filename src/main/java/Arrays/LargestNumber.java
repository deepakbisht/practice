package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created By Deepak Bisht on 14/05/20
 */
public class LargestNumber {

    static void largestNumber(List<String> arr) {

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String XY = o1 + o2;
                String YX = o2 + o1;

                System.out.println("XY:" + XY + ", YX:" + YX);
                return XY.compareTo(YX) > 0 ? 1 : -1;
            }
        });
        System.out.println(arr);
    }
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();;

        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        largestNumber(arr);

    }
}
