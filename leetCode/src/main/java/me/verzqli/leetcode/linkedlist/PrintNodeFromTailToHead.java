package me.verzqli.leetcode.linkedlist;

import java.util.Stack;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/5/16
 *     desc  : 从尾部到头部打印一个链表的每个节点
 *     solve : 1.从头遍历链表获得节点压入栈中，最后从栈里一个个取出来
 *             2.用递归，地柜就相当于一个栈，循环到最后一个节点在打印出来，一层层退出来就类似栈打印，不过如果链表
 *             层级过深会导致函数调用栈溢出，用第一种方式更好
 * </pre>
 */
public class PrintNodeFromTailToHead {
    public static void main(String[] args) {
        Node headNode = new Node();
        Node nextNode = new Node();
        headNode.next=nextNode;
        headNode.data=-11;
        nextNode.data=-22;
        for (int i = 0; i < 20; i++) {
            nextNode.data = i;
            nextNode.next = new Node();
            nextNode = nextNode.next;
        }
        printByRecursive(headNode);
    }

    /**
     * 用栈来存储节点
     * @param header
     */
    private static void print(Node header) {
        Stack<Node> nodeList=new Stack<>();
        Node node  =header;
        while(node!=null){
            nodeList.push(node);
            node = node.next;
        }
        while(!nodeList.isEmpty()){
            System.out.println("Node节点数据 = [" + nodeList.pop().data + "]");
        }
    }

    /**
     * 用递归来打印
     * @param header
     */
    private static void printByRecursive(Node header) {
        if (header==null){
            return;
        }
        if (header.next!=null){
            printByRecursive(header.next);
        }
        System.out.println("NodePrintByRecursive = [" + header.data + "]");
    }

}
