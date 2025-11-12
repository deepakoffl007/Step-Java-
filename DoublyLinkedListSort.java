class DoublyLinkedListSort {
    class Node {
        int data;
        Node prev, next;
        Node(int d) { data = d; }
    }
    Node head;
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    public void bubbleSort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node temp = head;
            while (temp.next != null) {
                if (temp.data > temp.next.data) {
                    int t = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = t;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedListSort list = new DoublyLinkedListSort();
        list.insert(40);
        list.insert(10);
        list.insert(30);
        list.insert(20);
        list.display();
        list.bubbleSort();
        list.display();
    }
}
