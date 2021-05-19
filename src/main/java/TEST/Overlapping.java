package TEST;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created By Deepak Bisht on 24/06/20
 */
public class    Overlapping {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void sortAndCompare(List<Point> nPointList, List<Point> qPointList) {

        for(int i = 0;i<qPointList.size();i++) {
            int count = 0;
            Point qPoint = qPointList.get(i);
            for(int j = 0;j<nPointList.size();j++) {
                Point nPoint = nPointList.get(j);
                if (nPoint.x >= qPoint.x || nPoint.y > qPoint.x) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Point> nPoints = new ArrayList<>();
        List<Point> qPoints = new ArrayList<>();

        Integer n = s.nextInt();
        while (n > 0) {
            nPoints.add(new Point(s.nextInt(), s.nextInt()));
            n--;
        }
        int q = s.nextInt();
        while (q > 0) {
            qPoints.add(new Point(s.nextInt(), s.nextInt()));
            q--;
        }
        sortAndCompare(nPoints, qPoints);
    }
}
