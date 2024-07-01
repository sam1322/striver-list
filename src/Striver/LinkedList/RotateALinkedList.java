package Striver.LinkedList;

public class RotateALinkedList {
    private static int findLength(Node head) {
        int cur = 0;
        while (head != null) {
            cur++;
            head = head.next;
        }
        return cur;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node newHead = reverse(head.next);
        Node nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

    public static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) return head;
        int len = findLength(head);
        System.out.println("length : " + len);
        k = k % len;
        k = len - k;// for reversing in right direction
//        Node newHead = reverse(head);
        Node cur = head;
        System.out.println("k after: " + k);
        for (int i = 0; i < k - 1 && cur.next != null; i++) {
            cur = cur.next;
            if (cur != null) {
                System.out.println("cur " + cur.data);
            } else {
                System.out.println("cur is null");
            }

        }
        Node first = head, second = cur.next;
        cur.next = null;
        Node newFirst = reverse(first), newSecond = reverse(second);
        head.next = newSecond;
        return reverse(newFirst);
    }


    static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }

    //utility function to print list
    static void printList(Node head) {
        while (head.next != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);

    }

    public static void main(String[] args) {
        Node head = null;
        //inserting Node
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 5);

        System.out.println("Original list: ");
        printList(head);

        int k = 2;
        Node newHead = rotateRight(head, k); //calling function for rotating right of the nodes by k times

        System.out.println("After " + k + " iterations: ");
        printList(newHead); //list after rotating nodes
    }
}
