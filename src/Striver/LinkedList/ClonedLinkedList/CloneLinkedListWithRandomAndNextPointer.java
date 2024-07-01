package Striver.LinkedList.ClonedLinkedList;


public class CloneLinkedListWithRandomAndNextPointer {
    public static Node copyRandomList(Node head) {
        if(head==null)return null;

        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            Node nextNode = cur.next;
            cur.next = newNode;
            newNode.next = nextNode;
            newNode.random = cur.random;
            cur = nextNode;
        }

        Node newHead = head.next;

        cur = head.next;
        while (cur != null ) {
            Node newRandom = null;
            if (cur.random != null) {
                newRandom = cur.random.next;
            }
            cur.random = newRandom;
//            cur = cur.next.next;

            if (cur.next != null) {
                cur = cur.next.next;
            } else {
                cur = null;
            }
        }

        //break the bonds
        cur = head;
        while (cur != null && cur.next != null) {
            Node nextNode = cur.next.next;
            Node newNode = cur.next;
            cur.next = nextNode;
            if (nextNode != null) {
                newNode.next = nextNode.next;
            }

            cur = cur.next;
        }

        return newHead;

    }

    public static void printClonedLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.val);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.val);
            } else {
                System.out.print(", Random: nullptr");
            }
            System.out.println();
            // Move to the next node in the list
            head = head.next;
        }
    }

    public static boolean checkIsClone(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1 == head2 || head1.random == head2.random) {
                System.out.println(head1.val + " ; " + head2.val);
                if (head1.random != null && head2.random != null) {
                    System.out.println(head1.random.val + " ; " + head2.random.val);
                }
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;

    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);

        // Clone the linked list
        Node clonedList = copyRandomList(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);

        System.out.println(checkIsClone(head, clonedList));
    }
}
