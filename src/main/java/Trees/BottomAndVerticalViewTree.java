package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created By Deepak Bisht on 05/06/20
 */
public class BottomAndVerticalViewTree {

    public static Map<Integer, Integer> viewNodes = new TreeMap<>();
    public static Map<Integer, List<Integer>> viewVerticalNodes = new TreeMap<>();

    static class Node {
        public int height;
        public Node left;
        public Node right;
        public int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void binaryTreeBottomView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node node = q.poll();
            viewNodes.put(node.height, node.data);
            if (node.left != null) {
                node.left.height = node.height - 1;
                q.add(node.left);
            }
            if (node.right != null) {
                node.right.height = node.height + 1;
                q.add(node.right);
            }
        }
    }

    public static void binaryTreeVerticalView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (viewVerticalNodes.get(node.height) == null) {
                List<Integer> nodes = new ArrayList<>();
                nodes.add(node.data);
                viewVerticalNodes.put(node.height, nodes);
            } else {
                List<Integer> nodes = viewVerticalNodes.get(node.height);
                nodes.add(node.data);
                viewVerticalNodes.put(node.height, nodes);
            }
            if (node.left != null) {
                node.left.height = node.height - 1;
                q.add(node.left);
            }
            if (node.right != null) {
                node.right.height = node.height + 1;
                q.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.left = new Node(4);
        root.right.right = new Node(25);

    //    binaryTreeBottomView(root);
        binaryTreeVerticalView(root);

      //  viewNodes.forEach((k, v) -> System.out.println(k + " : " + v));
        viewVerticalNodes.forEach((k, v) -> System.out.println(k + " : " + v));

     //   viewVerticalNodes.forEach((k, v) -> (v.forEach(i -> System.out.print(i))));
    }
}
