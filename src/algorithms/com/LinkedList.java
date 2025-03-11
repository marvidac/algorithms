package algorithms.com;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public static void main(String[] args) {
       LinkedList linkedList = new LinkedList(1);
       linkedList.append(4);

       System.out.println(linkedList.removeLast().value);
       linkedList.printAll();
       System.out.println(linkedList.removeLast().value);
       linkedList.printAll();
       System.out.println(linkedList.removeLast());
       linkedList.prepende(5);
       linkedList.prepende(6);
       linkedList.printAll();

        linkedList.removeFirst();
        linkedList.printAll();
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for(int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) { return null; }
        if(index == 0) { return removeFirst(); }
        if(index == length - 1) { return removeLast(); }

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepende(value);
            return true;
        }

        if(index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp;
        temp.next = newNode;
        length++;

        return true;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if(temp != null ){
            temp.value = value;
            return true;
        }

        return false;
    }

    public Node get(int index) {
        if(length == 0 || index > length) {
            return null;
        }

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public Node removeFirst() {
        if(length == 0) return null;
        Node temp = head;
        head = temp.next;
        temp.next = null;
        length--;

        if(length == 0) {
            tail = null;
        }

        return temp;
    }

    public void prepende(int value) {
        Node newNode = new Node(value);
        if(length == 0 ) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if(length == 0) return null;
        Node pre = head;
        Node temp = head;

        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;


        if(length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
