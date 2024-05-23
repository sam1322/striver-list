package Striver.Stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFUCache {
    static class Node {
        Node prev, next;
        int key, value;
        int freq;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
            freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node v) {
            Node next = head.next;
            head.next = v;
            v.prev = head;
            v.next = next;
            next.prev = v;
        }

        Node removeNode() {
            Node node = tail.prev;
            node.prev.next = tail;
            tail.prev = node.prev;
            return node;
        }

        Node removeNode(Node v) {
            Node prev = v.prev;
            Node next = v.next;
            prev.next = next;
            next.prev = prev;
            return v;
        }

        boolean isEmpty() {
            if (head.next == tail)
                return true;
            return false;
        }
    }

    //    Node head, tail;
    Map<Integer, Node> lfuCache = new HashMap<>();
    Map<Integer, DoublyLinkedList> freqList = new HashMap<>();

    int capacity;
    int minFreq;

    public LFUCache(int _capacity) {
        capacity = _capacity;
        minFreq = 1;
    }

    public void put(int key, int value) {
        if (this.capacity == 0) return;
        if (lfuCache.containsKey(key)) {
            Node node = lfuCache.get(key);
            freqList.get(node.freq).removeNode(node);
            if (freqList.get(node.freq).isEmpty()) {
                if (minFreq == node.freq) {
                    minFreq++;
                }
            }
            node.freq += 1;
            if (freqList.get(node.freq) == null) {
                DoublyLinkedList d = new DoublyLinkedList();
                d.addNode(node);
                freqList.put(node.freq, d);
            } else {
                freqList.get(node.freq).addNode(node);
            }
            node.value = value;
        } else {
            if (lfuCache.size() == capacity) {
                Node v = freqList.get(minFreq).removeNode();
                lfuCache.remove(v.key);
            }
            Node newNode = new Node(key, value);
            lfuCache.put(key, newNode);
            if (freqList.get(1) != null) {
                freqList.get(1).addNode(newNode);
            } else {
                DoublyLinkedList d = new DoublyLinkedList();
                d.addNode(newNode);
                freqList.put(1, d);
            }
            minFreq = 1;
        }
    }

    public int get(int key) {
        if (!lfuCache.containsKey(key))
            return -1;
        Node v = lfuCache.get(key);
        freqList.get(v.freq).removeNode(v);
        if (freqList.get(v.freq).isEmpty()) {
            if (minFreq == v.freq) {
                minFreq = v.freq + 1;
            }
        }
        v.freq++;
        if (freqList.get(v.freq) == null) {
            DoublyLinkedList d = new DoublyLinkedList();
            d.addNode(v);
            freqList.put(v.freq, d);
        } else {
            freqList.get(v.freq).addNode(v);
        }
        return v.value;
    }

    public static void main(String[] args) {

    }


}
