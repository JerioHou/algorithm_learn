package linkedlist;

public class CycleLinkedList {


    private Node head = null;
    private Node tail = null;

    public Node getHead() {
        return head;
    }


    public void insertToTail(Node data){
        if (head == null) {
            head = data;
            tail = data;
            tail.next = tail;
        } else {
            tail.next = data;
            tail = data;
            data.next = head;
        }
    }




    public static void main(String[] args) {
        CycleLinkedList cycleLinkedList = new CycleLinkedList();
        int count = 0;
        while (++count <= 5) {
            Node node = new Node(count,null);
            cycleLinkedList.insertToTail(node);
        }

        int step = 1;
        Node node = cycleLinkedList.getHead();
        while (node.next != node) {

            while (step > 1) {
                node = node.next;
                step--;
            }
            System.out.print(node.next.data+" ");
            node.next = node.next.next;

            node = node.next;

        }
        System.out.println();
        System.out.println(node.data);

    }


    private static class Node{
        private int data;
        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
