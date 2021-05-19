package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * Created By Deepak Bisht on 27/03/21
 */
public class IndexSum {

    static Map<Integer, HashSet> pairMap = new HashMap<>();

    public static void main(String... s) {
        int[] arr = new int[]{1, 4, 3, 2, 3, 7, 3};
        for (int i = 0; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - i);
            HashSet set = pairMap.get(abs);
            if (set == null) {
                set = new HashSet();
            }
            set.add(i);
            pairMap.put(abs, set);
        }
        System.out.println(pairMap);
    }
}

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x &&
                y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}