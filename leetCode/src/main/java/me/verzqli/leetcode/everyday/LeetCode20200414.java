package me.verzqli.leetcode.everyday;

import java.awt.List;

import me.verzqli.leetcode.ListNode;

/**
 * 每日一题：2020/04/14
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        //得出两个链表节点的差值
        int count = nodeLength1 - nodeLength2;
        ListNode node;
        if (count > 0) {
            maxLength = nodeLength1;
            //这里我保证的是长链一定在第一个，方便后面计算
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
            //如果count值大于0，说明node1一定比node2长，所以不断让node1向后遍历，直至为0时
            //为0时两者就一样长了，同时向后遍历获取两者的尾节点
            node1.next = solve(node1.next, node2, count, length);
            //这里要做两个进位判断，一个是上一层进位，一个是当前节点加上进位后又进位
            if (istep) {
                int val = node1.val + 1;
                istep = val >= 10;
                if (istep) {
                    node1.val = val - 10;
                } else {
                    node1.val = val;
                }
                //如果当前在长链条的头结点且还要进位时，需要创建一个进位头节点
                //这里注意，这个判断一定要放在这里面，因为上一层不进位，node1是不可能自己进位的
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
            //当node1.next为null时，说明两个链条已经到尾节点了，
            // 无需判断node2，因为node1前面已经设置好了是最长的
            if (node1.next == null) {
                int val = node1.val + node2.val;
                if (val >= 10) {
                    node = new ListNode(val - 10);
                    istep = true;
                    //如果当前两个只有一个节点时，直接创建一个进位返回即可
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
            //当两个链表长度是相同时，是进不去上面的count>0的循环，这里同样需要在写一个头结点相加是否进位
            if ((count + length + 1 == maxLength) && istep) {
                ListNode head = new ListNode(1);
                head.next = node;
                return head;
            }
            return node;

        }
    }

}
