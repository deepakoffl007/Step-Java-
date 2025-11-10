class CircularTaskManager {
    class Node {
        String task;
        int time;
        Node next;
        Node(String t, int ti) { task = t; time = ti; }
    }
    Node tail;
    public void addTask(String t, int ti) {
        Node newNode = new Node(t, ti);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void executeTasks() {
        if (tail == null) return;
        Node curr = tail.next;
        while (tail != null) {
            System.out.print(curr.task + " ");
            curr.time--;
            if (curr.time == 0) {
                if (curr == tail && curr.next == tail) {
                    tail = null;
                    break;
                }
                if (curr == tail) tail = tail.next;
                Node temp = tail.next;
                while (temp.next != curr) temp = temp.next;
                temp.next = curr.next;
                curr = curr.next;
            } else curr = curr.next;
        }
        System.out.println("\nAll Completed");
    }
    public static void main(String[] args) {
        CircularTaskManager tm = new CircularTaskManager();
        tm.addTask("T1", 3);
        tm.addTask("T2", 2);
        tm.addTask("T3", 4);
        tm.executeTasks();
    }
}
