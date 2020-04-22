package me.verzqli.leetcode.stack;

import java.util.Stack;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/6/10
 *     desc  : ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 *     deal  : �������Ƚ��ȳ���ջ���Ƚ������
 *             ������ջ��ʵ�ֶ��У������Ƚ�A����ջA�����B������B�ĳ�ջ˳��Ϊ�����е�˳��
 *             ���е����push��Ԫ����ջA
 *             ���еĳ���pop����B����Ԫ�أ���ֱ��B.pop()����B����Ԫ�أ���A������Ԫ�س�ջ������ջ��B���ٽ���B.pop()������
 * </pre>
 */
public class TwoStackBeQueen {
    public static void main(String[] args) {

    }
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        //�������Ƚ��ȳ���ջ���Ƚ������
        //������ջ��ʵ�ֶ��У������Ƚ�A����ջA�����B������B�ĳ�ջ˳��Ϊ�����е�˳��

        public void push(int node) {
            stack1.push(node);
        }

        public int pop(){
            if (stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

}
