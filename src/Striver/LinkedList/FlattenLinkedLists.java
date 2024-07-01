package Striver.LinkedList;


class ListNode {
    int data;
    ListNode next;
    ListNode child;

    // Constructors to initialize the
    // data, next, and child pointers
    ListNode() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    ListNode(int x) {
        this.data = x;
        this.next = null;
        this.child = null;
    }

    ListNode(int x, ListNode nextNode, ListNode childNode) {
        this.data = x;
        this.next = nextNode;
        this.child = childNode;
    }
}

public class FlattenLinkedLists {
    public static ListNode mergeTwoSortedLinkedLists(ListNode head1, ListNode head2) {
        ListNode dummyhead = new ListNode(-1);
        ListNode cur = dummyhead;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                cur.child = head1;
                head1 = head1.child;
            } else {
                cur.child = head2;
                head2 = head2.child;
            }
            cur = cur.child;
        }
        if (head1 != null) {
            cur.child = head1;
        }
        else if(head2 != null) {
            cur.child = head2;
        }
        return dummyhead.child;
    }

    // Function to print the linked list
    // traversing through child pointers
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }

    public static ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            cur = mergeTwoSortedLinkedLists(cur, nextNode);
            nextNode = nextNode.next;
        }
        return cur;
    }

    // Print the linked list
    // in a grid-like structure
    public static void printOriginalLinkedList(ListNode head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            // If child exists, recursively
            // print it with indentation
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars
            // for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }


    public static void main(String[] args) {
        // Create a linked list with child pointers
        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        // Print the original
        // linked list structure
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Flatten the linked list
        // and print the flattened list
        ListNode flattened = flattenLinkedList(head);
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}
