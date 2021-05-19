package Trees;

/**
 * Created By Deepak Bisht on 03/06/20
 */
public class LeftView {

    public static int curr_level = 0;

    public static void leftNode(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (curr_level < level) {
            System.out.println(root.data);
            curr_level = level;
        }
        leftNode(root.left, level + 1);
        leftNode(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);

        System.out.println(root.data);
        leftNode(root, 0);
    }
}
