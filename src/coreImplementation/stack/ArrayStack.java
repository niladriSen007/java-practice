package coreImplementation.stack;

class ArrStack {
    int[] stack;
    int top;
    int capacity;

    public ArrStack(int size) {
        stack = new int[size];
        top = -1;
        capacity = size;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = element;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}

public class ArrayStack {
    public static void main(String[] args) {
        ArrStack stack = new ArrStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
