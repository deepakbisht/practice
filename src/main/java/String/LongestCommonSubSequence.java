package String;

/**
 * Created By Deepak Bisht on 17/05/20
 */
public class LongestCommonSubSequence {

    public static int getLcs(String str1, String str2, int m, int n) {
        if (m == -1 || n == -1) {
            return 0;
        }
        if (str1.charAt(m) == str2.charAt(n)) {
            return 1 + getLcs(str1, str2, m - 1, n - 1) ;
        }
        return Integer.max(getLcs(str1, str2, m, n - 1), getLcs(str1, str2, m - 1, n));
    }

    public static int getLcsDP(String str1, String str2, int m, int n, Integer[][] arr) {
        if (m == -1 || n == -1) {
            return 0;
        }
        if (str1.charAt(m) == str2.charAt(n)) {
            if (arr[m][n] == null) {
                arr[m][n] =  getLcsDP(str1, str2, m - 1, n - 1, arr);
            }
            arr[m + 1][n + 1] = 1 + arr[m][n];
            printArray(arr);
            return arr[m + 1][n + 1];
        }
        if (arr[m][n + 1] == null) {
            arr[m][n + 1] = getLcsDP(str1, str2, m - 1, n, arr);
        }
        if (arr[m + 1][n] == null) {
            arr[m + 1][n] = getLcsDP(str1, str2, m, n - 1, arr);
        }
        arr[m + 1][n + 1] = Integer.max(arr[m][n + 1], arr[m + 1][n]);
        printArray(arr);
        return arr[m + 1][n + 1];
    }

    public static void printArray(Integer [][]arr) {

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                if(arr[i][j] == null) {
                    System.out.print("N"+" ");
                }
                else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str1 = "ybl";
        String str2 = "lb";
        Integer [][]arr = new Integer[str1.length()+1][str2.length()+1];
        for(int i =0;i<arr.length;i++){
            arr[i][0]=0;
        }
        for(int i=0;i<arr[0].length;i++) {
            arr[0][i]=0;
        }
        System.out.println(getLcsDP(str1, str2, str1.length()-1, str2.length()-1, arr));
       // System.out.println(getLcs(str1, str2, str1.length()-1, str2.length()-1));

    }
}
