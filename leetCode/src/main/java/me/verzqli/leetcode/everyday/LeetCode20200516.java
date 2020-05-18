package me.verzqli.leetcode.everyday;

import me.verzqli.leetcode.ListNode;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每?k?个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k?是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是?k?的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当?k?= 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当?k?= 3 时，应当返回: 3->2->1->4->5
 * <p>
 * ?
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200516 {
    public static void main(String[] args) {


    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode end = newHead;
        while (end.next!=null){
            for (int i = 0; i <k&&end!=null ; i++) {
                end = end.next;
            }
            if (end==null){
                break;
            }
            ListNode start = pre.next;
            ListNode nextStart = end.next;
            end.next = null;
            pre.next = reverseListNode(start);
            //这里注意 start变换后start本身没变
            //第二次基本写出来了 就是这个start.next有点没绕过弯
            start.next = nextStart;
            end = start;
            pre = end;

        }
        return newHead.next;

    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
