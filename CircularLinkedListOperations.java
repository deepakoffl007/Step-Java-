class CircularLinkedListOperations {
    class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }
    Node tail;
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void deleteAtBeginning() {
        if (tail == null) return;
        if (tail.next == tail) tail = null;
        else tail.next = tail.next.next;
    }
    public void deleteAtEnd() {
        if (tail == null) return;
        Node temp = tail.next;
        if (tail.next == tail) tail = null;
        else {
            while (temp.next != tail) temp = temp.next;
            temp.next = tail.next;
            tail = temp;
        }
    }
    public void display() {
        if (tail == null) return;
        Node temp = tail.next;
        do {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("back to " + tail.next.data);
    }
    public static void main(String[] args) {
        CircularLinkedListOperations list = new CircularLinkedListOperations();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.deleteAtBeginning();
        list.insertAtEnd(40);
        list.display();
    }
}
