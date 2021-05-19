package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created By Deepak Bisht on 08/06/20
 */
public class ConnectNodesAtSameLevel {

    public static Map<Integer, List<Node>> nodeConnector = new HashMap<>();

    static class Node {
        public Node left;
        public Node right;
        public Node next;
        public Node nextRight;
        public int data;
        public int level;

        Node(int data) {
            this.data = data;
        }
    }

    static void connect(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // null marker to represent end of current level
        q.add(null);

        // Do Level order of tree using NULL markers
        while (!q.isEmpty()) {
            Node p = q.peek();
            q.remove();
            if (p != null) {

                // next element in queue represents next
                // node at current Level
                p.nextRight = q.peek();

                // push left and right children of current
                // node
                if (p.left != null)
                    q.add(p.left);
                if (p.right != null)
                    q.add(p.right);
            }

            // if queue is not empty, push NULL to mark
            // nodes at this level are visited
            else if (!q.isEmpty())
                q.add(null);
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
            if (nodeConnector.get(node.level) == null) {
                List<Node> nodes = new ArrayList<>();
                nodes.add(node);
                nodeConnector.put(node.level, nodes);
            } else {
                List<Node> nodes = nodeConnector.get(node.level);
                nodes.get(nodes.size() - 1).next = node;
                nodes.add(node);
            }
            if (node.left != null) {
                node.left.level = node.level + 1;
                q.add(node.left);
            }
            if (node.right != null) {
                node.right.level = node.level + 1;
                q.add(node.right);
            }
        }
        nodeConnector.forEach((k, v) -> printList(v.get(0)));
    }

    public static void printList(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        // binaryTreeVerticalView(root);
        connect(root);
    }

}
