package LinkList;

/**
 * Created By Deepak Bisht on 22/05/20
 */

/*      5 -> 10 -> 19 -> 28
        |    |     |     |
        V    V     V     V
        7    20    22    35
        |          |     |
        V          V     V
        8          50    40
        |                |
        V                V
        30               45
*/

public class MiscellanousLinkList {

    public static class Node {
        public int data;
        public Node next;
        public Node down;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node sortAndMerge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data > b.data) {
            b.down = sortAndMerge(a, b.down);
            return b;
        } else {
            a.down = sortAndMerge(a.down, b);
            return a;
        }
    }

    public static Node flatten(Node start) {
        Node temp = start;
        while (temp != null) {
            temp.down = sortAndMerge(temp.down, temp.next);
            temp = temp.next;
        }
        return start;
    }

    public static void printList(Node start) {
        Node temp = start;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.down;
        }
    }

    public static void main(String[] args) {
        MiscellanousLinkList.Node start = new MiscellanousLinkList.Node(5);
        start.down = new Node(7);
        start.down.down = new Node(8);
        start.down.down.down = new Node(30);

        Node a = new Node(10);
        a.down = new Node(20);
        start.next = a;
        // another

        Node b = new Node(19);
        b.down = new Node(22);
        b.down.down = new Node(50);
        a.next = b;
        //
        Node c = new Node(28);
        c.down = new Node(35);
        c.down.down = new Node(40);
        c.down.down.down = new Node(45);
        b.next = c;

        printList(flatten(start));
    }
}
