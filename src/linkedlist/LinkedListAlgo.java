package linkedlist;

public class LinkedListAlgo {


    public static void main(String[] args) {
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,null);
        node1.next = node2;
        Node node3 = new Node(3,null);
        node2.next = node3;
        Node node4 = new Node(4,null);
        node3.next = node4;
        Node node5 = new Node(5,null);
        node4.next = node5;

        Node node = getLastKth(node1, 5);
        System.out.println(node);


    }

    /**
     * 链表中环的检测
     */

    /**
     * 两个有序的链表合并
     */

    /**
     * 获取链表倒数第 K 个结点
     * 思路：使用两个指针，先把fast指针指向第K+1个节点
     * 然后 slow指针指向第一个节点
     * 然后两个指针同步移动
     * 当fast.next = null时，slow.pre就是倒数第K个节点
     */
    public static Node getLastKth(Node list,int k) {
        Node fast = list;
        int i = 1;
        while (fast.next != null && i < k) {
            fast = fast.next;
            ++i;
        }
        if (i < k ) {
            return null;
        }
        // 此时fast刚好第K个元素,头节点就是倒数第K
        if (fast.next == null) {
            return list;
        }
        Node slow = list;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 求链表的中间结点
     */





    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }


        @Override
        public String toString() {
            return data+"";
        }
    }

}
