package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Deepak Bisht on 17/05/20
 */
public class LongestDistinctChar {

    private static final int NO_OF_CHARS =  256;

    public static int countDistinct(String str, int i, int j, Set<Character> distinct) {
        if (i > j) {
            return Integer.MIN_VALUE;
        }
        if (i == j) {
            return 1;
        }
        if (i == j - 1) {
            if (str.charAt(i) == str.charAt(j)) {
                return distinct.size() + 1;
            }
            return distinct.size() + 2;
        }
        if (distinct.contains(str.charAt(i))) {
            return distinct.size();
        } else {
            distinct.add(str.charAt(i));
            int a = countDistinct(str, i + 1, j, distinct);
            distinct = new HashSet<>();
            int b = countDistinct(str, i + 1, j, distinct);
            return Integer.max(a, b);
        }
    }

    public static int countDistinctDP(String str) {
        int max_distinct_chars = 0;
        Set<Character> distinctChars = new HashSet<>();
        distinctChars.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (distinctChars.contains(str.charAt(i))) {
                max_distinct_chars = Integer.max(max_distinct_chars, distinctChars.size());
                distinctChars = new HashSet<>();
            }
            distinctChars.add(str.charAt(i));
            if (i == str.length() - 1) {
                max_distinct_chars = Integer.max(max_distinct_chars, distinctChars.size());
            }
        }
        return max_distinct_chars;
    }

    static int longestUniqueSubsttr(String str)
    {
        int n = str.length();

        int res = 0; // result

        // last index of all characters is initialized
        // as -1
        int [] lastIndex = new int[NO_OF_CHARS];
        Arrays.fill(lastIndex, -1);

        // Initialize start of current window
        int i = 0;

        // Move end of current window
        for (int j = 0; j < n; j++) {

            // Find the last index of str[j]
            // Update i (starting index of current window)
            // as maximum of current value of i and last
            // index plus 1
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);

            // Update result if we get a larger window
            res = Math.max(res, j - i + 1);

            // Update last index of j.
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "aewergrththy";
       // System.out.println(countDistinct(str, 0, str.length() - 1, new HashSet<>()));
        System.out.println(countDistinctDP(str));
    }
}
