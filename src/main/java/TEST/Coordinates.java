package TEST;

/**
 * Created By Deepak Bisht on 14/08/20
 */
public class Coordinates {

   // static Integer [][] possibleSolutions = new Integer[Integer.MAX_VALUE][Integer.MAX_VALUE];

    static boolean isReachable(long a, long b,
                               long x, long y)
    {
         System.out.println("Function Call: a:" + a + " b:" + b);
        // base case
        if (a > x || b > y)
            return false;

        // current point is equal to destination
        if (a == x && b == y)
            return true;

        // check for other 2 possibilities
        return (isReachable(a + b, b, x, y) ||
                isReachable(a, b + a, x, y));
    }

    static long gcd(long i, long j) {
        while (i != j) {
            if (i > j)
                i -= j;
            else
                j -= i;
        }
        return i;
    }

    //driver code
    public static void main(String arg[]) {
        int source_x = 1, source_y = 1;
        int dest_x = 280, dest_y = 290;
        System.out.println((gcd(1, 1) == gcd(dest_x, dest_y)));
        /*if (isReachable(source_x, source_y, dest_x,
                dest_y))
            System.out.print("Yes");
        else
            System.out.print("No");*/
    }
}
