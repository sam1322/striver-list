package Striver.LinkedList;

public class IsPalindrome {
    public static Node tortoiseAndHare(Node head) {
        Node slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome(Node head) {
        Node slow = tortoiseAndHare(head);
        Node newHead = ReverseLinkedList.reverseLinkedList(slow.next);
        Node first = head, second = newHead;
        boolean flag = true;
        while (second != null) {
            if (first.data != second.data) {
                flag = false;
                break;
            }
            second = second.next;
            first = first.next;
        }
        ReverseLinkedList.reverseLinkedList(newHead);
        return flag;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);

//        head.next.next.next = new Node(2);
//        head.next.next.next.next = new Node(3);
//        head.next.next.next.next.next = new Node(1);

//        Node head = new Node(1);
//        head.next = new Node(3);
//        head.next.next = new Node(2);
//        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(7);
        System.out.println(isPalindrome(head));
    }
}
