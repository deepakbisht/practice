/**
 * Created By Deepak Bisht on 09/05/20
 */
public class FastFibo {

    public static int fast_fib(int n, Integer[] table) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            if (table[n - 1] == null) {
                table[n - 1] = fast_fib(n - 1, table);
            }
            if (table[n - 2] == null) {
                table[n - 2] = fast_fib(n - 2, table);
            }
            table[n] = table[n - 1] + table[n - 2];
            return table[n];
        }
    }

    public static void rearrange(int arr[], int n)
    {
        // initialize index of first minimum and first
        // maximum element
        int max_idx = n - 1, min_idx = 0;

        // store maximum element of array
        int max_elem = arr[n - 1] + 1;

        // traverse array elements
        for (int i = 0; i < n; i++) {
            // at even index : we have to put
            // maximum element
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                max_idx--;
                System.out.println(arr[i]);
            }

            // at odd index : we have to put minimum element
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
                System.out.println(arr[i]);
            }
        }

        // array elements back to it's original form
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;
    }

    public static void main(String[] args) {
        System.out.println(fast_fib(7, new Integer[8]));
        int arr[] = { 1,4,13,17,19,21,63 };
        int n = arr.length;

        System.out.println("Original Array");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        rearrange(arr, n);

        System.out.print("\nModified Array\n");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
