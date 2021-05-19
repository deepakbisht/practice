package String;

import java.util.Scanner;

/**
 * Created By Deepak Bisht on 16/05/20
 */
public class CreatePalindrome {

    public static int buildPalindrome(String str) {
        int i=0;
        int j = str.length()% 2== 0 ? 1 : 0;
        int mid = (str.length() -1)/2;
        int numberOfCharsRequired = 0;
        while((mid-i) >=0 && (mid+j) < str.length()) {
            if(str.charAt(mid-i) != str.charAt(mid+j)) {
                numberOfCharsRequired+=2;
            }
            i++;
            j++;
        }
        if(numberOfCharsRequired != 0) {
            return numberOfCharsRequired -1;
        }
        return numberOfCharsRequired;
    }

    static int findMinInsertions(char str[], int l,
                                 int h)
    {
        // Base Cases
        if (l > h) return Integer.MAX_VALUE;
        if (l == h) return 0;
        if (l == h - 1) return (str[l] == str[h])? 0 : 1;

        // Check if the first and last characters
        // are same. On the basis of the  comparison
        // result, decide which subrpoblem(s) to call
        return (str[l] == str[h])?
                findMinInsertions(str, l + 1, h - 1):
                (Integer.min(findMinInsertions(str, l, h - 1),
                        findMinInsertions(str, l + 1, h)) + 1);
    }

    static int findMinInsertionsDP(String str, int i , int j, Integer[][] insertionSoFar) {
        if (i > j) {
            return Integer.MAX_VALUE;
        }
        if (i == j) {
            insertionSoFar[i][j] = 0;
            return 0;
        }
        if (i == j - 1) {
            if (str.charAt(i) == str.charAt(j)) {
                insertionSoFar[i][j] = 0;
                return 0;
            } else {
                insertionSoFar[i][j] = 1;
                return 1;
            }
        }
        if (str.charAt(i) == str.charAt(j)) {
            if (insertionSoFar[i][j] == null) {
                insertionSoFar[i][j] = findMinInsertionsDP(str, i + 1, j - 1, insertionSoFar);
            }
            return insertionSoFar[i][j];
        } else {
            if (insertionSoFar[i + 1][j] == null) {
                insertionSoFar[i + 1][j] = findMinInsertionsDP(str, i + 1, j, insertionSoFar);
            }
            if (insertionSoFar[i][j - 1] == null) {
                insertionSoFar[i][j - 1] = findMinInsertionsDP(str, i, j - 1, insertionSoFar);
            }
        }
        return Integer.min(insertionSoFar[i + 1][j], insertionSoFar[i][j - 1]) + 1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        input.nextLine();
        while(testCases > 0) {
            String str = input.nextLine();
            Integer [][]insertionSofar = new Integer[str.length()][str.length()];
            System.out.println(findMinInsertionsDP(str,0, str.length()-1,insertionSofar));
        }
    }
}
