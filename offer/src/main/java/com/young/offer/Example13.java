package com.young.offer;

public class Example13 {
    public static void main(String[] args) {
//        new Example13().solve();
    }

    public void solve(Node head, Node deleteNode) {
        if (head == null || deleteNode == null) {
            return;
        }
        //如果被删节点是头结点。
        if (deleteNode == head) {
            head = head.next;
            //如果被删节点是尾结点。
        } else if (deleteNode.next == null) {
            Node node = head;
            while (node.next != deleteNode) {
                node = node.next;
            }
            node.next = null;
            //如果被删节点是普通结点。
        } else {
            Node next = deleteNode.next;
            deleteNode.value = next.value;
            deleteNode.next = next.next;
        }
    }

}
