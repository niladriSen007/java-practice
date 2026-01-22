package coreImplementation.stack;

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedListStack {
    private Node head;
    private int size;
    private final int capacity;

    public LinkedListStack(int capacity) {
        size = 0;
        this.capacity = capacity;
    }

    public void push(int value) {
        if (size == capacity) {
            System.out.println("Stack is full");
        }
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if (head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popped = head.value;
        head = head.next;
        return popped;
    }

    public int peek() {
        if (head == null)
            return -1;
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class LLStack {
    public static void main(String[] args) {
        LinkedListStack llStack = new LinkedListStack(5);
        llStack.push(10);
    }
}
