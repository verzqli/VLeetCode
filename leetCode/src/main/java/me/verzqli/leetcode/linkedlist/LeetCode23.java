package me.verzqli.leetcode.linkedlist;

/**
 * \
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 可以联动剑指offer 例17
 */
public class LeetCode23 {
    public static void main(String[] args) {
//        new LeetCode23().solve();
    }

    /**
     * 循环
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
     * 两两归并
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
    //用二分法让两两节点互相比较
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
