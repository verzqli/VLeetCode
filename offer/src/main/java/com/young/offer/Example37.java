package com.young.offer;

import java.util.List;

/**
 * ������52. ��������ĵ�һ�������ڵ�
 * �������������ҳ����ǵĵ�һ�������ڵ㡣
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 */
public class Example37 {
    public static void main(String[] args) {
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        //������û�н���ʱ����Ϊ������a+b,�����������ָ��null�����Է��ص�Ҳ��null����������ѭ��
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

}
