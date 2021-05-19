package Arrays;

/**
 * Created By Deepak Bisht on 01/05/21
 */
public class ContingousSubArraySum {

    static void max_sub_array(int[] arr) {
        int temporary_max = arr[0], max_result = arr[0];
        int begin = 0, end = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > temporary_max + arr[i]) {
                begin = i;
                temporary_max = arr[i];
            } else {
                temporary_max = temporary_max + arr[i];
            }
            if (temporary_max > max_result) {
                end = i;
                max_result = temporary_max;
            }
        }
        System.out.println("Begin: "+ begin+","+" End: "+ end + " SUM: "+ max_result);
    }

    public static void main(String[] args) {

        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4, 100 };
        max_sub_array(arr);
    }
}
