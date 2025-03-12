package src.algorithms.com;

public class DoubleLinkedList {
    Node head;
    Node tail;
    int length = 0;

    public void append(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if(length == 0) return null;
        Node temp = tail;

        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;

        if(length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }


    class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
