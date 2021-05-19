package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Created By Deepak Bisht on 06/06/20
 */
public class LevelOrderSpiralTraversal {

    static Map<Integer, List<Integer>> leftToRight = new HashMap<Integer, List<Integer>>();
    static Map<Integer, Stack> rightToleft = new HashMap<>();

    static class Node {
        public int height;
        public Node left;
        public Node right;
        public int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    public static void printLevelOrderInSpiral(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (((node.height) % 2 == 0)) {
                if (leftToRight.get(node.height) == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(node.data);
                    leftToRight.put(node.height, list);
                } else {
                    List<Integer> list = leftToRight.get(node.height);
                    list.add(node.data);
                    leftToRight.put(node.height, list);
                }
            } else {
                if (rightToleft.get(node.height) == null) {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(node.data);
                    rightToleft.put(node.height, stack);
                } else {
                    Stack<Integer> stack = rightToleft.get(node.height);
                    stack.push(node.data);
                    rightToleft.put(node.height, stack);
                }
            }
            if (node.left != null) {
                node.left.height = node.height + 1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.height = node.height + 1;
                queue.add(node.right);
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

        printLevelOrderInSpiral(root);
        int height = height(root);
        for (int i = 0; i <= height; i++) {
            if ((i % 2) == 0) {
                System.out.println(leftToRight.get(i));
            } else {
                Stack stack = rightToleft.get(i);
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
            }
        }
    }
}
