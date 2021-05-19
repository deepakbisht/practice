package Arrays;

/**
 * Created By Deepak Bisht on 12/05/20
 */
public class MinPlatform {

    static int minPlatform(int arrival[], int departure[], int n)
    {

        // as time range from 0 to 2359 in 24 hour clock,
        // we declare an array for values from 0 to 2360
        int [] platform = new int[2361];
        int requiredPlatform = 1;
        for (int i = 0; i < n; i++) {

            // increment the platforms for arrival
            ++platform[arrival[i]];

            //decremented at the next instant because arrival and departure time same will need different platform
            --platform[departure[i] + 1];
        }

        for (int i = 0; i < platform.length; i++) {
            if (platform[i] != 0) {
                System.out.println("Time:" + i + " platformCount:" + platform[i]);
            }
        }

        // We are running loop till 2361 because maximum time value
        // in a day can be 23:60
        for (int i = 1; i < 2361; i++) {

            // taking cumulative sum of platform give us required
            // number of platform fro every minute
            platform[i] = platform[i] + platform[i - 1];
            if (platform[i] != 0)
     //           System.out.println("Time: " + i + "Adding platform:" + platform[i]);
            requiredPlatform = Math.max(requiredPlatform, platform[i]);
        }
        return requiredPlatform;
    }

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(minPlatform(arr, dep, arr.length));
    }

    public void test() {
        try {
            String nnumber = "twenty";
            int twenty = Integer.parseInt(nnumber);
            System.out.println(twenty);
        }
        catch (Exception e) {

        }
    }
}
