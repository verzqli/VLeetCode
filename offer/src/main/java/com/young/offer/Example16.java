package com.young.offer;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class Example16 {
    public static void main(String[] args) {
        Node head = new Node();
        head.value = 0;
        Node node = head;
        for (int i = 1; i < 6; i++) {
            Node next = new Node();
            next.value = i;
            node.next = next;
            node = node.next;

        }

        Node node1 = new Example16().recursionSolve(head);
        for (int i = 0; i < 6; i++) {
            System.out.printf("vvv" + node1.value);
            node1 = node1.next;
        }
        System.out.printf("" + node1.next);
    }

    //递归调用
    public Node recursionSolve(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node result = recursionSolve(node.next);
        node.next.next = node;
        node.next = null;
        return result;
    }

    public Node solve(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prevNode = null;
        Node curNode = head;
        Node result = null;
        while (curNode != null) {
            Node nextNode = curNode.next;
            if (nextNode == null) {
                result = curNode;
            }
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return result;
    }

}
