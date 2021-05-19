package Trees;

/**
 * Created By Deepak Bisht on 11/06/20
 */
public class MaxPathSum {

    public static int max_sum;

    public static void maxPathSumBT(TreeNode<Integer> root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.data;
        if (root.left == null && root.right == null) {
            if (sum > max_sum) {
                max_sum = sum;
            }
        }
        if (root.left != null) {
            maxPathSumBT(root.left, sum);
        }
        if (root.right != null) {
            maxPathSumBT(root.right, sum);
        }
    }

    public static void preOrder(TreeNode<Integer> root) {
        if (root != null) {
            maxPathSumBT(root, 0);
            preOrder(root.left);
            preOrder((root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(-15);
        root = new TreeNode(-15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(-8);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(0);
        root.right.right.right.left = new TreeNode(4);
        root.right.right.right.right = new TreeNode(-1);
        root.right.right.right.right.left = new TreeNode(10);

        preOrder(root);

        System.out.println(max_sum);

    }
}
