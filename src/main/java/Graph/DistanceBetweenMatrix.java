package Graph;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created By Deepak Bisht on 01/05/21
 */
public class DistanceBetweenMatrix {

    static int[] rowNeighbour = new int[]{0, -1, 0, 1};
    static int[] colNeighbour = new int[]{-1, 0, 1, 0};

    static boolean safeToAdd(int row, int column, int m, int n) {
        return row >= 0 && row <= m && column >= 0 && column <= n;
    }

    public static void main(String[] args) {
        int[][] grid = {{31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}};
        calculateDistance(grid, 4, 4);
    }

    static int calculateDistance(int[][] arr, int m, int n) {
        Node lastNode = null;
        Set<Node> nodeSet = new LinkedHashSet<Node>();
        int[][] result = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        result[0][0] = arr[0][0];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((m + 1) * (n + 1), (a, b) -> (a.weight - b.weight));
        priorityQueue.add(new Node(0, 0, result[0][0] , null));
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (currentNode.row == m && currentNode.col == n) {
                lastNode = currentNode;
            }
            nodeSet.add(currentNode);
            for (int i = 0; i <= 3; i++) {
                int newRowNeighbour = currentNode.row + rowNeighbour[i];
                int newColumnNeighbour = currentNode.col + colNeighbour[i];
                if (safeToAdd(newRowNeighbour, newColumnNeighbour, m, n)) {
                    int sum = result[currentNode.row][currentNode.col] + arr[newRowNeighbour][newColumnNeighbour];
                    if (result[newRowNeighbour][newColumnNeighbour] > sum) {
                        Node newNode = new Node(newRowNeighbour, newColumnNeighbour, sum, currentNode);
                        if (result[newRowNeighbour][newColumnNeighbour] == Integer.MAX_VALUE) {
                            priorityQueue.add(newNode);
                        }
                        result[newRowNeighbour][newColumnNeighbour] = sum;
               //         printArray(result);
                    }
                }
            }
        }
     //   printNode(resultList);
     //   System.out.println(result[m][n]);
  //      System.out.println(nodeSet);
        printPath(lastNode);
        return result[m][n];
    }

    static void printPath(Node node) {
        if (node == null) {
            return;
        }
        printPath(node.parent);
        System.out.println("(" + node.row + "," + node.col + ")" + " -> " + node.weight);
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                }
            System.out.println("\n");
        }
    }

    static void printNode(List<Node> nodeList) {
        nodeList.forEach(node -> System.out.println("(" + node.col + "," + node.col + ")"));
    }
}


class Node {
    int row;
    int col;
    int weight;
    Node parent;

    public Node(int row, int col, int weight, Node parent) {
        this.row = row;
        this.col = col;
        this.weight = weight;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return row == node.row &&
                col == node.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "Node{" +
                "row=" + row +
                ", col=" + col +
                ", weight=" + weight +
                ", parent=" + parent +
                '}';
    }
}
