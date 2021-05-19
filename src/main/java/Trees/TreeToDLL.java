package Trees;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created By Deepak Bisht on 09/06/20
 */
public class TreeToDLL {
    public static Stack<Integer> stack = new Stack<>();
    public static LinkedList<Integer> dll = new LinkedList<>();
    public static  TreeNode<Integer> head;
    public static TreeNode<Integer> prev;
    public static void inOrder(TreeNode<Integer> root) {
        if (root != null) {
            inOrder(root.left);
            dll.add(root.data);
            inOrder(root.right);
        }
    }


    public static void convertBT2DLLLessSpace(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        convertBT2DLLLessSpace(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convertBT2DLLLessSpace(root.right);
    }

   /* public static void createeDLL() {
        while (!stack.isEmpty()) {
            dll.addFirst(stack.pop());
        }
        System.out.println(dll);
    }*/

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        /*root.left = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        root.right = new TreeNode(30);*/


        //inOrder(root);
        convertBT2DLLLessSpace(root);
        TreeNode temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.right;
        }

        //createeDLL();

        System.out.println(dll);
    }
}
