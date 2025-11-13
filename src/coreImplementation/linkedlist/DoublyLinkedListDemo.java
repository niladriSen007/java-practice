package coreImplementation.linkedlist;

public class DoublyLinkedListDemo {
    private Node head;

    DoublyLinkedListDemo() {
        this.head = null;
    }

    public static void main(String[] args) {
        DoublyLinkedListDemo doublyLinkedListDemo = new DoublyLinkedListDemo();
        doublyLinkedListDemo.printList();
        doublyLinkedListDemo.append(12);
        doublyLinkedListDemo.append(89);
        doublyLinkedListDemo.append(34);
        doublyLinkedListDemo.prepend(11);
        doublyLinkedListDemo.prepend(81);
        doublyLinkedListDemo.insertAtIndex(2, 99);
        doublyLinkedListDemo.insertAtIndex(2, 87);
        doublyLinkedListDemo.delete(99);
        doublyLinkedListDemo.delete(87);
        doublyLinkedListDemo.printList();
    }

    public void append(int value) {
        Node node = new Node(value);
        if (head == null) head = node;
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
            node.next = null;
        }
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (head == null) head = node;
        else {
            Node current = head;
            head = node;
            node.next = current;
            current.prev = node;
        }
    }

    public void insertAtIndex(int index, int value) {
        if (index < 0) System.out.println("Index not found");
        else {
            if (index == 0) {
                append(value);
            } else {
                Node newNode = new Node(value);
                Node node = head;
                int idx = 1;
                while (idx < index) {
                    node = node.next;
                    idx++;
                }
                Node exNode = node.next;
                node.next = newNode;
                newNode.prev = node;
                newNode.next = exNode;
                exNode.prev = newNode;
            }
        }
    }

    public void delete(int value) {
        if (head == null) System.out.println("List is empty");
        else {
            Node current = head;
            while (current != null) {
                if (current.value == value) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    return;
                } else {
                    current = current.next;
                }
            }
        }
    }

    public void printList() {
        Node node = head;
        if (head == null) System.out.println("List is empty");
        else {
            while (node != null) {
                System.out.print(node.value + " <-> ");
                node = node.next;
            }
        }
    }


    public static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}
