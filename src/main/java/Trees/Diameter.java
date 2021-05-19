package Trees;

/**
 * Created By Deepak Bisht on 13/06/20
 */
public class Diameter {

    public static int max_diameter;

    public static int getDiameter(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ls = getDiameter(root.left);
        int rs = getDiameter(root.right);
        if (root.left != null && root.right != null) {
            max_diameter = Math.max(max_diameter, ls + rs + 1);
            return Math.max(ls, rs) + 1;
        } else {
            return root.left != null ? ls + 1 : rs + 1;
        }
    }

    public static int height(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.left.left = new TreeNode(9);
        root.left.left.left.left.left = new TreeNode(10);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        System.out.println(getDiameter(root));
        System.out.println(max_diameter);

    }
}
