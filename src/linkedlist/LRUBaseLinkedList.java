package linkedlist;

import java.util.Scanner;

public class LRUBaseLinkedList {

    private final static Integer DEFAULT_CAPACITY = 3;

    private Node head;

    private int count;

    private int capacity ;


    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public void insertToHead(int value){
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        count++;
    }


    private void add(int value) {
        Node node = head;
        Node pre = head;
        if (node == null) {
            insertToHead(value);
            return;
        }
        if (head.data == value){
            return;
        }
        while (node.next != null) {
            if (node.data == value) {
                pre.next = node.next;
                node = node.next;
                count--;
                break;
            }
            pre = node;
            node = node.next;
        }
        if (count >= capacity || node.data == value) {
            pre.next = null;
            count--;
        }
        insertToHead(value);
    }

    private void printAll() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + ",");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node{
        private int data;
        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}
