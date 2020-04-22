package me.verzqli.leetcode.everyday;

import java.awt.List;

import me.verzqli.leetcode.ListNode;

/**
 * ÿ��һ�⣺2020/04/14
 * �������� �ǿ� ���������������Ǹ��������������λλ������ʼλ�á����ǵ�ÿ���ڵ�ֻ�洢һλ���֡�����������ӻ᷵��һ���µ�����
 * ����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��
 * ���ף�
 * <p>
 * ��������������޸ĸ���δ������仰˵���㲻�ܶ��б��еĽڵ���з�ת��
 * <p>
 * ʾ����
 * <p>
 * ���룺(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * �����7 -> 8 -> 0 -> 7
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/add-two-numbers-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200414 {
    public boolean istep = false;
    public ListNode head;
    public int maxLength = 0;

    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        int nodeLength1 = 0;
        int nodeLength2 = 0;
        ListNode temp = node1;
        while (temp.next != null) {
            nodeLength1++;
            temp = temp.next;
        }
        temp = node2;
        while (temp.next != null) {
            nodeLength2++;
            temp = temp.next;
        }
        //�ó���������ڵ�Ĳ�ֵ
        int count = nodeLength1 - nodeLength2;
        ListNode node;
        if (count > 0) {
            maxLength = nodeLength1;
            //�����ұ�֤���ǳ���һ���ڵ�һ��������������
            node = solve(node1, node2, count, nodeLength2);
        } else {
            maxLength = nodeLength2;
            node = solve(node2, node1, -count, nodeLength1);
        }
        return node;
    }

    private ListNode solve(ListNode node1, ListNode node2, int count, int length) {
        if (count > 0) {
            count--;
            //���countֵ����0��˵��node1һ����node2�������Բ�����node1��������ֱ��Ϊ0ʱ
            //Ϊ0ʱ���߾�һ�����ˣ�ͬʱ��������ȡ���ߵ�β�ڵ�
            node1.next = solve(node1.next, node2, count, length);
            //����Ҫ��������λ�жϣ�һ������һ���λ��һ���ǵ�ǰ�ڵ���Ͻ�λ���ֽ�λ
            if (istep) {
                int val = node1.val + 1;
                istep = val >= 10;
                if (istep) {
                    node1.val = val - 10;
                } else {
                    node1.val = val;
                }
                //�����ǰ�ڳ�������ͷ����һ�Ҫ��λʱ����Ҫ����һ����λͷ�ڵ�
                //����ע�⣬����ж�һ��Ҫ���������棬��Ϊ��һ�㲻��λ��node1�ǲ������Լ���λ��
                if ((count + length + 1 == maxLength) && istep) {
                    ListNode head = new ListNode(1);
                    head.next = node1;
                    return head;
                }
            }
            return node1;
        } else {
            length--;
            ListNode node = null;
            //��node1.nextΪnullʱ��˵�����������Ѿ���β�ڵ��ˣ�
            // �����ж�node2����Ϊnode1ǰ���Ѿ����ú��������
            if (node1.next == null) {
                int val = node1.val + node2.val;
                if (val >= 10) {
                    node = new ListNode(val - 10);
                    istep = true;
                    //�����ǰ����ֻ��һ���ڵ�ʱ��ֱ�Ӵ���һ����λ���ؼ���
                    if (length + 1 == maxLength) {
                        ListNode head = new ListNode(1);
                        head.next = node;
                        return head;
                    }
                } else {
                    node = new ListNode(val);
                    istep = false;
                }
                return node;
            }
            ListNode preNode = solve(node1.next, node2.next, 0, length);
            int val = node1.val + node2.val;
            if (istep) {
                val += 1;
            }
            if (val >= 10) {
                node = new ListNode(val - 10);
                istep = true;
            } else {
                node = new ListNode(val);
                istep = false;
            }
            node.next = preNode;
            //����������������ͬʱ���ǽ���ȥ�����count>0��ѭ��������ͬ����Ҫ��дһ��ͷ�������Ƿ��λ
            if ((count + length + 1 == maxLength) && istep) {
                ListNode head = new ListNode(1);
                head.next = node;
                return head;
            }
            return node;

        }
    }

}
