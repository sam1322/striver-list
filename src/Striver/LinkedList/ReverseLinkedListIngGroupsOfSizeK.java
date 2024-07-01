package Striver.LinkedList;

public class ReverseLinkedListIngGroupsOfSizeK {
    public static Node reverseLinkedListK(Node head, int K) {
        if (head == null) return null;
        Node cur = head;
        int k = K;
        while (cur != null) {
            if (k == 1) {
                break;
            }
            cur = cur.next;
            k--;
        }
        if (cur == null) {
            return head;
        } else {
            Node nextNode = cur.next;
            cur.next = null;
            Node newHead = ReverseLinkedList.reverseLinkedList(head);
            head.next = reverseLinkedListK(nextNode, K);
            return newHead;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next.next.next = new Node(41);
        head.next.next.next.next.next.next.next.next.next = new Node(421);
        head.next.next.next.next.next.next.next.next.next.next = new Node(4133);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        ReverseLinkedList.printLinkedList(head);

        Node newHead = reverseLinkedListK(head,3);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        ReverseLinkedList.printLinkedList(newHead );
    }
}
