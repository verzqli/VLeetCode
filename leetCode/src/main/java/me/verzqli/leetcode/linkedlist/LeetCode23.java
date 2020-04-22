package me.verzqli.leetcode.linkedlist;

/**
 * \
 * �ϲ� k �������������غϲ������������������������㷨�ĸ��Ӷȡ�
 * ����:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * ���: 1->1->2->3->4->4->5->6
 * ����������ָoffer ��17
 */
public class LeetCode23 {
    public static void main(String[] args) {
//        new LeetCode23().solve();
    }

    /**
     * ѭ��
     *
     * @param list
     * @return
     */
    public Node solve(Node[] list) {
        if (list.length == 0) {
            return null;
        }
        Node newHead = list[0];
        for (int i = 1; i < list.length; i++) {
            newHead = mergeNodeList(newHead, list[i]);
        }
        return newHead;
    }

    /**
     * �����鲢
     *
     * @param lists
     * @return
     */
    public Node solve2(Node[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    //�ö��ַ��������ڵ㻥��Ƚ�
    private Node merge(Node[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        Node node1 = merge(lists, start, mid);
        Node node2 = merge(lists, mid + 1, end);
        return mergeNodeList(node1, node2);
    }

    private Node mergeNodeList(Node node, Node node1) {
        if (node == null) {
            return node1;
        }
        if (node1 == null) {
            return node;
        }
        Node head = null;
        if (node.val > node1.val) {
            head = node1;
            head.next = mergeNodeList(node1.next, node);
        } else {
            head = node;
            head.next = mergeNodeList(node.next, node1);
        }
        return head;
    }

}
