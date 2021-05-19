package StackAndQueue;

/**
 * Created By Deepak Bisht on 31/05/20
 */
public class RottenOranges {

    public static  int R=3,C=5;
    public static boolean issafe(int i, int j)
    {
        if (i >= 0 && i < R && j >= 0 && j < C)
            return true;
        return false;
    }

    public static int rotOranges(int [][]v)
    {
        boolean changed = false;
        int no = 2;
        while (true) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {

                    if (v[i][j] == no) {
                        if (issafe(i + 1, j) && v[i + 1][j] == 1) {
                            v[i + 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j + 1) && v[i][j + 1] == 1) {
                            v[i][j + 1] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i - 1, j) && v[i - 1][j] == 1) {
                            v[i - 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j - 1) && v[i][j - 1] == 1) {
                            v[i][j - 1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }

            printArray(v);

            if (!changed)
                break;
            changed = false;
            no++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {


                if (v[i][j] == 1)
                    return -1;
            }
        }

        return no - 2;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][]v = { { 2, 1, 0, 2, 1 },
            { 1, 0, 1, 2, 1 },
            { 1, 0, 0, 2, 1 } };
        System.out.println(rotOranges(v));
    }
}
