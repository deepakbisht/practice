package Threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Deepak Bisht on 09/05/21
 */
public class TreeNode {

    TreeNode parent = null;
    List children = new ArrayList();

    public synchronized void addChild(TreeNode child) throws InterruptedException {
        if (!this.children.contains(child)) {
            this.children.add(child);
            Thread.sleep(5000);
            child.setParentOnly(this);
        }
    }

    public synchronized void addChildOnly(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent) throws InterruptedException {
        this.parent = parent;
        Thread.sleep(5000);
        parent.addChildOnly(this);
    }

    public synchronized void setParentOnly(TreeNode parent) {
        this.parent = parent;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                try {
                    treeNode.addChild(new TreeNode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                try {
                    treeNode.setParent(new TreeNode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable2, "Thread-2");
        t1.start();
        t2.start();
    }
}