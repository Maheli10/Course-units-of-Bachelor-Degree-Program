public class CircularLinkedList {
    ChainNode head;
    int size;

    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
	
    public int size() {
        return size;
    }

    public void addFirst(Object elt) {
        ChainNode newNode = new ChainNode(elt);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head; // Point to itself
        } else {
            ChainNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Object elt) {
        ChainNode newNode = new ChainNode(elt);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head;
        } else {
            ChainNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public Object removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        Object removedData = head.data;
        if (size == 1) {
            head = null;
        } else {
            ChainNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        }
        size--;
        return removedData;
    }

    public Object removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        Object removedData;
        if (size == 1) {
            removedData = head.data;
            head = null;
        } else {
            ChainNode temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            removedData = temp.next.data;
            temp.next = head;
        }
        size--;
        return removedData;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        ChainNode temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        System.out.println("Adding elements to the circular list:");
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
        list.display(); // Output: 10 -> 20 -> 30 -> (head)

        list.addLast(40);
        list.addLast(50);
        list.display(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> (head)

        System.out.println("\nRemoving first element: " + list.removeFirst());
        list.display(); // Output: 20 -> 30 -> 40 -> 50 -> (head)

        System.out.println("Removing last element: " + list.removeLast());
        list.display(); // Output: 20 -> 30 -> 40 -> (head)
    }
}