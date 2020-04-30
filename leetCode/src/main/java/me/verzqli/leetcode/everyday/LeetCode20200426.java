package me.verzqli.leetcode.everyday;

import me.verzqli.leetcode.ListNode;

/**
 * 合并?k?个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ? 1->4->5,
 * ? 1->3->4,
 * ? 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
