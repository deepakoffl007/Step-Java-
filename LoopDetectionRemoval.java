class LoopDetectionRemoval {
    class Node {
        int data;
        Node next;
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
        }
    }
    public void createLoop(int pos) {
        if (head == null) return;
        Node loopNode = head, temp = head;
        for (int i = 1; i < pos && loopNode != null; i++) loopNode = loopNode.next;
        while (temp.next != null) temp = temp.next;
        temp.next = loopNode;
    }
    public void detectAndRemoveLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LoopDetectionRemoval list = new LoopDetectionRemoval();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.createLoop(3);
        list.detectAndRemoveLoop();
        list.display();
    }
}
