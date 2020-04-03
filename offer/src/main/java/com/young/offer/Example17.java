package com.young.offer;

/**
 *
 */
public class Example17 {
    public static void main(String[] args) {
        Node node1 = createNode1();
        Node node2 = createNode2();
        Node result = new Example17().solve(node1, null);
    }

    public Node solve(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }
        Node newHead = null;
        if (node1.value < node2.value) {
            newHead = node1;
            newHead.next = solve(node1.next, node2);
        } else {
            newHead = node2;
            newHead.next = solve(node2.next, node1);
        }
        return newHead;
    }

    private static Node createNode1() {
        Node node = new Node(7, null);
        Node node1 = new Node(5, node);
        Node node2 = new Node(4, node1);
        Node node3 = new Node(2, node2);
        return node3;

    }

    private static Node createNode2() {
        Node node = new Node(9, null);
        Node node1 = new Node(6, node);
        Node node2 = new Node(4, node1);
        Node node3 = new Node(1, node2);
        return node3;
    }


}
