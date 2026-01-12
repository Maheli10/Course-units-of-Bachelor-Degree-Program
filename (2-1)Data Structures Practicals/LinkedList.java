
class ChainNode {
    Object data;
    ChainNode next;

    // Constructor 
    ChainNode(Object data) {
        this.data = data;
        this.next = null;
    }

    ChainNode(Object data, ChainNode next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList {
    ChainNode head;
    int size;

    LinkedList() {
        this.size = 0;
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Object elt) {
        head = new ChainNode(elt, head);
        size++;
    }

    public void addLast(Object elt) {
        if (isEmpty()) {
            head = new ChainNode(elt);
        } else {
            ChainNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ChainNode(elt);
        }
        size++;
    }

    public Object removeFirst() {
        Object rmdata = null;
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            rmdata = head.data;
            head = head.next;
            size--;
        }
        return rmdata;
    }

    public Object removeLast() {
        Object rmdata = null;
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            if (size == 1) {
                rmdata = head.data;
                head = null;
            } else {
                ChainNode temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                rmdata = temp.next.data;
                temp.next = null;
            }
            size--;
        }
        return rmdata;
    }

    public void insertNode(int index, Object elt) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            addFirst(elt);
        } else if (index == size) {
            addLast(elt);
        } else {
            ChainNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new ChainNode(elt, temp.next);
            size++;
        }
    }

    public Object removeNode(int index) {
        if (index < 0 || index >= size || isEmpty()) {
            System.out.println("Invalid index or list is empty");
            return null;
			}

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            ChainNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Object rmdata = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return rmdata;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
        } else {
            ChainNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(); // Adds a newline at the end
        }
    }

    // Testing the LinkedList
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addFirst(30);
        l1.addFirst(20);
        l1.addFirst(10);
        l1.display(); // 10 20 30

        l1.addLast(40);
        l1.display(); // 10 20 30 40

        l1.insertNode(2, 25);
        l1.display(); // 10 20 25 30 40

        System.out.println("Removed: " + l1.removeNode(1)); // Remove 20
        l1.display(); // 10 25 30 40
    }
}
