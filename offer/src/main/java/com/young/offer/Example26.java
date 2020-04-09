package com.young.offer;

/**
 * 请实现函数ComplexListNode复制一个复杂链表。在复杂链表中，
 * 每个结点除了有一个next指针指向下一个结点外，还有一个randomNext 指向链表中的任意结点或者NULL.结点。
 */
public class Example26 {
    public static void main(String[] args) {
        System.out.printf("aaa"+(new Example26().solve(new SpecialNode(1)).val));;
    }

    public SpecialNode solve(SpecialNode head) {
        if (head == null) {
            return head;
        }
        SpecialNode cur = head;
        while (cur != null) {
            SpecialNode temp = new SpecialNode(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        SpecialNode newHead = head.next;
        cur = head;
        SpecialNode newCur = head.next;
        while (cur != null) {
            //这里的目的是把两条链完全分开，不然不算拷贝成功，因为有别的节点next指向拷贝上的节点,同时也是循环退出点
            cur.next = cur.next.next;
            cur = cur.next;
            //这里注意，上面没有做next为null时因为后面一定跟着复制品，而复制品后面不一定跟着节点，所以这里做null判断
            if (newCur.next != null) {
                newCur.next = newCur.next.next;
                newCur = newCur.next;
            }
        }
        return newHead;
    }

    public static class SpecialNode {
        int val;
        SpecialNode next;
        SpecialNode random;

        public SpecialNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
