package linkedlist;

public class SinglyLinkedList {

    private Node head = null;
    private Node tail = null;
    private int count;

    public void insertToHead(int value) {
        Node node = new Node(value,null);
        insertToHead(node);
    }

    public synchronized void insertToHead(Node data) {
        if (head == null) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head = data;
        }
        count++;
    }

    public synchronized void deleteTail(){
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node node = head;
        while (node.next.next == null) {
            node.next = null;
            return;
        }
    }

    private static class Node{
        private int data;
        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void printAll() {
        Node node = head;
        if (node == null) {
            return;
        }
        while (node.next != null) {
            System.out.print(node.data +" ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    private void reverse(){
        if (head == null) {
            return;
        }
        Node node = head;
        Node pre = null;
        Node temp = null;
        while (node != null) {
            temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        head = pre;
    }


    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertToHead(1);
        linkedList.insertToHead(2);
//        linkedList.insertToHead(3);
//        linkedList.insertToHead(6);
//        linkedList.insertToHead(2);
//        linkedList.insertToHead(6);
//        linkedList.insertToHead(8);

        linkedList.printAll();
        linkedList.reverse();
        linkedList.printAll();
    }


}
