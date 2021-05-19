package TEST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created By Deepak Bisht on 24/06/20
 */
public class POintSort {

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

    public static void sortPoint(List<Point> pointList) {
        Comparator<Point> compare = Comparator
                .comparing(Point::getX)
                .thenComparing(Point::getY);

        Collections.sort(pointList, new XSorter()
                .thenComparing(new YSorter()));
      //  Collections.sort(pointList, compare);

        pointList.forEach(point -> System.out.println(point.x + " " + point.y));
    }

    public static class XSorter implements Comparator<Point>
    {
        @Override
        public int compare(Point o1, Point o2) {
            return  o1.getX() - o2.getX();
        }
    }

    public static class YSorter implements Comparator<Point>
    {
        @Override
        public int compare(Point o1, Point o2) {
            return  o2.getY() - o1.getY();
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Point> points = new ArrayList<>();
        Integer n = s.nextInt();
        while (n > 0) {
            points.add(new Point(s.nextInt(), s.nextInt()));
            n--;
        }
        sortPoint(points);
    }
}
