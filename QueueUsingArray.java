import java.util.*;
public class QueueUsingArray {
    int front, rear, size;
    int[] queue;
    QueueUsingArray(int capacity) {
        queue = new int[capacity];
        front = rear = size = 0;
    }
    boolean isFull() { return size == queue.length; }
    boolean isEmpty() { return size == 0; }
    void enqueue(int data) {
        if (isFull()) return;
        queue[rear] = data;
        rear = (rear + 1) % queue.length;
        size++;
    }
    int dequeue() {
        if (isEmpty()) return -1;
        int val = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return val;
    }
    int peek() { return isEmpty() ? -1 : queue[front]; }
    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.peek());
    }
}
