package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Deepak Bisht on 13/05/20
 */
public class StockSell {

    public static int calculate_Profit(int[] arr) {
        int profit = 0;
        int curr_min_index = 0;
        Map<Integer, Integer> salesIndex = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                if ( (i-curr_min_index) > 1) {
                    salesIndex.put(curr_min_index, i - 1);
                    profit = 0;
                    curr_min_index = i;
                }
            } else {
                profit += arr[i] - arr[i - 1];
                if (i == arr.length - 1) {
                    salesIndex.put(curr_min_index, i);
             //       System.out.println("(" + curr_min + " " + i + ")");

                }
            }
        }
        salesIndex.forEach((k, v) -> System.out.print("(" + k + " " + v + ")" + " "));
        return profit;
    }
    public static void main (String[] args) {
        //code
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        System.out.print(calculate_Profit(price));
    }
}
