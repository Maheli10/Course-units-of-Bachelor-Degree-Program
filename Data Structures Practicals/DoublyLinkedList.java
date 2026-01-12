
class DoublyLinkedNode {
    Object data;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;

    DoublyLinkedNode(Object data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

//Doubly Linked List class
public class DoublyLinkedList {
    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Object elt) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(elt);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Object elt) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(elt);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
			tail = newNode;
        }
        size++;
    }

    public Object removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        Object removedData = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return removedData;
    }

    public Object removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        Object removedData = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return removedData;
    }

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        DoublyLinkedNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        DoublyLinkedNode current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("Adding elements to the list:");
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        System.out.print("List (forward): ");
        list.displayForward(); // 5 <-> 10 <-> 20 <-> 30 <-> null

        System.out.print("List (backward): ");
        list.displayBackward(); // 30 <-> 20 <-> 10 <-> 5 <-> null

        System.out.println("\nRemoving elements:");
        System.out.println("Removed first: " + list.removeFirst()); // 5
        System.out.println("Removed last: " + list.removeLast());   // 30

        System.out.print("List after removals: ");
        list.displayForward(); // 10 <-> 20 <-> null
    }
}
