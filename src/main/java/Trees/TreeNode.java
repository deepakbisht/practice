package Trees;

/**
 * Created By Deepak Bisht on 03/06/20
 */
public class TreeNode<T> {
    public T data;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {

    }

    TreeNode(T data) {
        this.data = data;
    }
}
