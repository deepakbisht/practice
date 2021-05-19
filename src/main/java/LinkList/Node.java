package LinkList;

/**
 * Created By Deepak Bisht on 25/05/20
 */
public class Node {
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
    }

    public static void printList(Node start) {
        Node temp = start;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
