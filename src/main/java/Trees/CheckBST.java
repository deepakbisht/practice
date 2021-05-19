package Trees;

/**
 * Created By Deepak Bisht on 03/06/20
 */
public class CheckBST {
    public static boolean checkBST(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.data.intValue() < ((Integer) root.left.data).intValue()) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.data.intValue() >= ((Integer) root.right.data).intValue()) {
                return false;
            }
        }
        return checkBST(root.left) && checkBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);
        System.out.println(checkBST(root));
    }
}
