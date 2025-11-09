import java.util.*;
class SinglyLinkedListInsertion {
    class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }
    Node head;
    public void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos <= 1 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SinglyLinkedListInsertion list = new SinglyLinkedListInsertion();
        list.insertAtPosition(10, 1);
        list.insertAtPosition(20, 2);
        list.insertAtPosition(30, 3);
        list.insertAtPosition(40, 4);
        list.insertAtPosition(50, 3);
        list.display();
    }
}
