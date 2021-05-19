package Graph;

/**
 * Created By Deepak Bisht on 27/04/21
 */
public class FloydWarshall {

    static int result[][] = new int[4][4];

    public static void printAllShortestPaths(int[][] arr) {

        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    result[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
            System.out.println("Session:" + k);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(result[i][j]+ " ");
                }
                System.out.println();
            }
            arr = result;
        }

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{
                0, 2, 20, 10},
                {5, 0, 3, 4},
                {9999, 2, 0, 2},
                {3, 9999, 15, 0}
        };

        printAllShortestPaths(arr);

    }
}
