package com.exercise.sourceCode_scan;

public class HashSetSource {
    public static void main(String[] args) {
        Node[] table = new Node[16];
        Node john = new Node("John", null);
        table[2] = john;
        Node jack = new Node("Jack", null);
        john.next = jack;
        Node rose = new Node("Rose", null);
        jack.next = rose;
        Node lucy = new Node("Lucy", null);
        table[3] = lucy;
        System.out.println(table);

    }
}
class Node{
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}