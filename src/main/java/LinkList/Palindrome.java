package LinkList;

/**
 * Created By Deepak Bisht on 25/05/20
 */
public class Palindrome {


    public static boolean checkForPalindrome(Node node){
        Node mid = middleNode(node);
        Node second_half = mid.next;
        Node temp = node;
        int no_of_nodes = totalLength(node);
        while (temp != mid && second_half != null) {
            if (temp.data == second_half.data) {
                temp = temp.next;
                second_half = second_half.next;
            }
        }
        if (temp != mid || second_half != null) {
            return false;
        }

        return true;
    }

    public static Node middleNode(Node node){
        Node fast = node;
        Node slow = node;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Integer totalLength(Node node) {
        Node slow = node;
        int count = 0;
        while (slow != null) {
            slow = slow.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(2);
        list1.next.next.next.next = new Node(1);
       System.out.println(checkForPalindrome(list1));
    }
}
