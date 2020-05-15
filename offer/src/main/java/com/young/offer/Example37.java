package com.young.offer;

import java.util.List;

/**
 * 面试题52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 */
public class Example37 {
    public static void main(String[] args) {
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        //当两者没有交点时，因为都走了a+b,所以两者最后都指向null，所以返回的也是null，不会无限循环
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

}
