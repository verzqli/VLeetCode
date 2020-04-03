package com.young.offer;

public class Example15 {
    public static void main(String[] args) {
        Node head = new Node();
        head.value =0;
        Node node = head;
        for (int i = 1; i < 6; i++) {
            Node next = new Node();
            next.value = i;
            node.next = next;
            node = node.next;
        }


    }

    public Node solve(Node head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        Node node = head;
        Node node2 = head;
        k--;
        while (node.next != null) {
            if (k != 0) {
                k--;
            } else {
                node2 = node2.next;
            }
            node=node.next;
        }
        if (k > 0) {
            System.out.println("超过范围");
            return null;
        }
        return node2;
    }

}
