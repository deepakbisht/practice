package LinkList;

/**
 * Created By Deepak Bisht on 19/05/20
 */


public class LinkedListQuestions {

    static class Node {
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }

    }

    public static Node reverseInGroups(Node start, int k){

        Node temp = start;
        Node kthNode = null;
        int j = k;
        if (start == null || start.next == null || k == 0 || k < 0) {
            return start;
        }

        while(k!=0) {
            kthNode=temp;
            temp=temp.next;
            if(temp==null){
                break;
            }
            k--;
        }
        kthNode.next = null;
        Node reversedlist = reverse(start);
        start.next = reverseInGroups(temp, j);
        return reversedlist;
    }

    static Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    public static Node rotate(Node start, int k) {
        if (start == null) {
            return null;
        }
        if (k < 0 || k == 0) {
            return start;
        }
        Node temp = start;
        Node prev = null;
        while (k > 0) {
            if (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            // k >length
            if (temp == null) {
                return start;
            }
            k--;
        }
        prev.next = null;
        Node newHead = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = start;
        start = newHead;
        printList(start);
        return start;
    }

    public static void printList(Node start) {
        Node temp = start;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node detectAndRemoveLoop(Node start) {
        if (start == null || start.next == null) {
            return start;
        }
        Node slow = start.next;
        Node fast = start.next.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == fast) {
            slow = start;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
        return start;
    }

    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        Node a = start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);
        start.next.next.next.next.next = new Node(6);
        Node b = start.next.next.next.next.next.next = new Node(7);
        b.next = a;
        printList(detectAndRemoveLoop(start));

        //printList(reverseInGroups(start, 100));
    }
}

