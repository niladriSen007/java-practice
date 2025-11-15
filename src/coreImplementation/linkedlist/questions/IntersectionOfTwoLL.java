package coreImplementation.linkedlist.questions;

import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoLL {

    public static void main(String[] args) {
        //approach 1: Brute force o(m * n) m = List1 length , n= List2 length
        //approach 2: Hashset(store list b values into hashset then traverse list a nodes) O(m+n)
        //approach 3: Two pointer
        LinkedList<Node> list1 = new LinkedList<>();
        list1.add(new Node(4));
        list1.add(new Node(1));
        list1.add(new Node(8));
        list1.add(new Node(4));
        list1.add(new Node(5));

        for (int i = 0; i < list1.size() - 1; i++) {
            list1.get(i).next = list1.get(i + 1);
        }
        ;
        list1.getLast().next = null;


        List<Node> list2 = new LinkedList<>();
        list2.add(new Node(5));
        list2.add(new Node(6));
        list2.add(new Node(1));
        list2.add(new Node(8));
        list2.add(new Node(4));
        list2.add(new Node(5));

        for (int i = 0; i < list2.size() - 1; i++) {
            list2.get(i).next = list2.get(i + 1);
        }
        ;
        list2.getLast().next = null;


        Node actualFirstNodeHead = list1.getFirst();
        Node actualSecondNodeHead = list2.getFirst();


        Node firstListHead = actualFirstNodeHead;
        Node secondListHead = actualSecondNodeHead;


        while (firstListHead != secondListHead) {
            firstListHead = firstListHead == null ? actualSecondNodeHead : firstListHead.next;
            secondListHead = secondListHead == null ? actualFirstNodeHead : secondListHead.next;
        }

        System.out.println(secondListHead);
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
