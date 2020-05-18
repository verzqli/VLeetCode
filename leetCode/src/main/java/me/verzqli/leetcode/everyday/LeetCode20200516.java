package me.verzqli.leetcode.everyday;

import me.verzqli.leetcode.ListNode;

/**
 * 25. K ��һ�鷭ת����
 * <p>
 * ����һ������ÿ?k?���ڵ�һ����з�ת�����㷵�ط�ת�������
 * <p>
 * k?��һ��������������ֵС�ڻ��������ĳ��ȡ�
 * <p>
 * ����ڵ���������?k?������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * �����������1->2->3->4->5
 * <p>
 * ��?k?= 2 ʱ��Ӧ������: 2->1->4->3->5
 * <p>
 * ��?k?= 3 ʱ��Ӧ������: 3->2->1->4->5
 * <p>
 * ?
 * <p>
 * ˵����
 * <p>
 * ����㷨ֻ��ʹ�ó����Ķ���ռ䡣
 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻����
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
            //����ע�� start�任��start����û��
            //�ڶ��λ���д������ �������start.next�е�û�ƹ���
            start.next = nextStart;
            end = start;
            pre = end;

        }
        return newHead.next;

    }

    /**
     * ��ת����
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
