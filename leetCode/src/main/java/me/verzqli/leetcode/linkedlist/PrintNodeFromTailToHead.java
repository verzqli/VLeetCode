package me.verzqli.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/5/16
 *     desc  : ��β����ͷ����ӡһ�������ÿ���ڵ�
 *     solve : 1.��ͷ���������ýڵ�ѹ��ջ�У�����ջ��һ����ȡ����
 *             2.�õݹ飬�ع���൱��һ��ջ��ѭ�������һ���ڵ��ڴ�ӡ������һ����˳���������ջ��ӡ�������������
 *             �㼶����ᵼ�º�������ջ������õ�һ�ַ�ʽ����
 * </pre>
 */
public class PrintNodeFromTailToHead {
    public static void main(String[] args) {
        Node headNode = new Node();
        Node nextNode = new Node();
        headNode.next=nextNode;
        headNode.val=-11;
        nextNode.val=-22;
        for (int i = 0; i < 20; i++) {
            nextNode.val = i;
            nextNode.next = new Node();
            nextNode = nextNode.next;
        }
        printByRecursive(headNode);
    }

    /**
     * ��ջ���洢�ڵ�
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
            System.out.println("Node�ڵ����� = [" + nodeList.pop().val + "]");
        }
    }

    /**
     * �õݹ�����ӡ
     * @param header
     */
    private static void printByRecursive(Node header) {
        if (header!=null){
            printByRecursive(header.next);
        }
        System.out.println("NodePrintByRecursive = [" + header.val + "]");
    }
    /**
     * ����arraylist
     * @param header
     */
    ArrayList<Integer> result=new ArrayList<>();
    private  ArrayList<Integer> printByRecursiveReturnList(Node header) {
        if (header!=null){
            printByRecursiveReturnList(header.next);
            result.add(header.val);
        }
        return result;
    }
}
