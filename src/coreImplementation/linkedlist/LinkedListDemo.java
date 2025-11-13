package coreImplementation.linkedlist;

public class LinkedListDemo {
    private Node head;

    LinkedListDemo() {
        this.head = null;
    }

    public static void main(String[] args) {
        LinkedListDemo linkedListDemo = new LinkedListDemo();
        linkedListDemo.printList();
        linkedListDemo.append(12);
        linkedListDemo.append(132);
        linkedListDemo.append(42);
        linkedListDemo.prepend(1);
        linkedListDemo.prepend(2);
        linkedListDemo.insertAtIndex(2, 99);
        linkedListDemo.insertAtIndex(2, 23);
        linkedListDemo.delete(99);
        linkedListDemo.delete(23);
        linkedListDemo.printList();
    }

    public void append(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node exHead = head;
            head = node;
            node.next = exHead;
        }
    }

    public void insertAtIndex(int index, int value) {
        if (index < 0) System.out.println("Index not found");
        else {
            Node newNode = new Node(value);
            Node node = head;
            int idx = 1;
            if (index == 0) append(value);
            else {
                while (idx < index) {
                    node = node.next;
                    idx++;
                }
                Node exNode = node.next;
                node.next = newNode;
                newNode.next = exNode;
            }
        }
    }

    public void delete(int value) {
        Node node = head;
        Node prev = null;
        if (node.value == value) {
            head = node.next;
            node.next = null;
        }
        while (node != null) {
            if (node.value != value) {
                prev = node;
                node = node.next;
            } else {
                prev.next = node.next;
                node.next = null;
                return;
            }
        }
    }

    public void printList() {
        Node node = head;
        if (head == null) System.out.println("List is empty");
        else {
            while (node != null) {
                System.out.print(node.value + " -> ");
                node = node.next;
            }
        }
    }

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
