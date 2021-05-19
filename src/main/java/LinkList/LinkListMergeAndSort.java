package LinkList;

/**
 * Created By Deepak Bisht on 25/05/20
 */
public class LinkListMergeAndSort {

    Node addTwoLists(Node first, Node second) {
        Node res = null; // res is head node of the resultant list
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while (first != null || second != null) //while both lists exist
        {
            // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + (first != null ? first.data : 0)
                    + (second != null ? second.data : 0);

            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Create a new node with sum as data
            temp = new Node(sum);

            // if this is the first node then set it as head of
            // the resultant list
            if (res == null) {
                res = temp;
            } else // If this is not the first node then connect it to the rest.
            {
                prev.next = temp;
            }

            // Set prev for next insertion
            prev = temp;

            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        // return head of the resultant list
        return res;
    }

    public static Node mergeSortedList(Node head1, Node head2) {
        Node mergeList = null;
        Node currentMergePointer = null;
        if (head1 == null) {
            mergeList = head2;
        }
        if (head2 == null) {
            mergeList = head1;
        }
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (mergeList == null) {
                    mergeList = head1;
                    currentMergePointer = mergeList;
                    head1 = head1.next;
                } else {
                    currentMergePointer.next = head1;
                    currentMergePointer = currentMergePointer.next;
                    head1 = head1.next;
                }
            } else if (head2.data < head1.data) {
                if (mergeList == null) {
                    mergeList = head2;
                    currentMergePointer = mergeList;
                    head2 = head2.next;
                } else {
                    currentMergePointer.next = head2;
                    currentMergePointer = currentMergePointer.next;
                    head2 = head2.next;
                }
            } else {
                currentMergePointer.next = head1;
                currentMergePointer.next.next = head2;
                currentMergePointer = currentMergePointer.next.next;
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            currentMergePointer.next = head2;
        }
        if (head2 == null) {
            currentMergePointer.next = head1;
        }
        return mergeList;
    }


    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(7);
        // SingleList
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);
        list2.next.next.next = new Node(8);
        Node.printList(mergeSortedList(list1, list2));

    }
}
