package me.verzqli.leetcode.everyday;

import me.verzqli.leetcode.ListNode;

/**
 * �ϲ�?k?�������������غϲ������������������������㷨�ĸ��Ӷȡ�
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * [
 * ? 1->4->5,
 * ? 1->3->4,
 * ? 2->6
 * ]
 * ���: 1->1->2->3->4->4->5->6
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-k-sorted-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200426 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = null;
       return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {

        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode node1 = merge(lists, start, mid);
        ListNode node2 = merge(lists, mid + 1, end);

        return mergeNode(lists, node1, node2);
    }

    private ListNode mergeNode(ListNode[] lists, ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode head = null;
        if (node1.val > node2.val) {
            head = node2;
            head.next = mergeNode(lists, node1, node2.next);
        } else {
            head = node1;
            head.next = mergeNode(lists, node2, node1.next);
        }
        return head;
    }

}
