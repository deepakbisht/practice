package TEST;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created By Deepak Bisht on 24/06/20
 */
public class SOLUTION {

    public static void printNextGreatestParity(int num) {
        int numParity = getParity(num);
        int temp = num + 1;
        while (getParity(temp) != numParity + 1) {
            temp++;
        }
        System.out.println(temp);
    }
    public static int getParity(int n)
    {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If divisors are equal,
                // count only one
                if (n / i == i)
                    cnt++;

                else // Otherwise count both
                    cnt = cnt + 2;
            }
        }
        System.out.println(cnt);
        return cnt;
    }

    static boolean findParity(int x)
    {
        int y = x ^ (x >> 1);
        y = y ^ (y >> 2);
        y = y ^ (y >> 4);
        y = y ^ (y >> 8);
        y = y ^ (y >> 16);
        if ((y & 1) > 0)
            return true;
        return false;
    }
    public static void calculateDifference(String currentTime, String inputdate) {


        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(currentTime);
            d2 = format.parse(inputdate);

            //in milliseconds
            long diff = d1.getTime() - d2.getTime();
            if(diff == 0) {
                System.out.println("now");
                return;
            }

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            if(diffHours>0){
                if(diffHours==1) {
                    System.out.println("1 hour ago");
                } else {
                    System.out.println(diffHours + " hours ago");
                }
                return;
            }

            if(diffMinutes>0){
                if(diffMinutes==1) {
                    System.out.println("1 minute ago");
                } else {
                    System.out.println(diffMinutes + " minutes ago");
                }
                return;
            }

            if(diffSeconds>0){
                if(diffSeconds==1) {
                    System.out.println("1 second ago");
                } else {
                    System.out.println(diffSeconds + " seconds ago");
                }
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        while (n > 0) {
            printNextGreatestParity(s.nextInt());
            n--;
        }
        /*String currentTime = s.nextLine();
        Integer n = s.nextInt();
        s.nextLine();
        while (n > 0) {
            calculateDifference(currentTime, s.nextLine());
            n--;
        }*/
    }
}
