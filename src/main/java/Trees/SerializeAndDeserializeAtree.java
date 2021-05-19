package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Deepak Bisht on 14/06/20
 */
public class SerializeAndDeserializeAtree {
    public static Queue<Integer> preOrderOfTree = new LinkedList<Integer>();

    public static TreeNode<Integer> node;

    static public void preOrder(TreeNode<Integer> root) {
        if(root == null) {
            preOrderOfTree.add(-1);
            return;
        }
        preOrderOfTree.add(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static TreeNode<Integer> deSerialize(TreeNode<Integer> node) {
        if (preOrderOfTree.peek() == -1) {
            preOrderOfTree.remove();
            node = new TreeNode<>(null);
            return null;
        }
        System.out.println(preOrderOfTree.peek());
        node = new TreeNode<Integer>(preOrderOfTree.poll());
        node.left = deSerialize(node.left);
        node.right = deSerialize(node.right);
        return node;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(20);
        root.left               = new TreeNode<>(8);
        root.right              = new TreeNode<>(22);
        root.left.left         = new TreeNode<>(4);
        root.left.right        = new TreeNode<>(12);
        root.left.right.left  = new TreeNode<>(10);
        root.left.right.right = new TreeNode<>(14);

        preOrder(root);
        System.out.println(preOrderOfTree);
        node = deSerialize(node);
        preOrder(root);
        System.out.println(preOrderOfTree);
    }
}
