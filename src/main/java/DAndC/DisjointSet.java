package DAndC;

import java.util.Arrays;

/**
 * Created By Deepak Bisht on 24/04/21
 */
public class DisjointSet {
    Integer parent[];

    DisjointSet(int n) {
        parent = new Integer[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int find(int s) {
        if (s == parent[s]) {
            printMatrix(parent);
            return s;
        }
        return parent[s] = find(parent[s]);
    }

    void merge(int u, int v) {
        parent[v] = u;
    }

    void printMatrix(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    @Override
    public String toString() {
        return "DisjointSet{" +
                "parent=" + Arrays.toString(parent) +
                '}';
    }
}
