package me.verzqli.leetcode.stack;

import java.util.Stack;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/6/10
 *     desc  : 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *     deal  : 队列是先进先出，栈是先进后出。
 *             用两个栈来实现队列，可以先进A，出栈A后进入B，最终B的出栈顺序为出队列的顺序。
 *             队列的入队push：元素入栈A
 *             队列的出队pop：若B中有元素，则直接B.pop()；若B中无元素，则将A中所有元素出栈，并入栈到B后，再进行B.pop()操作。
 * </pre>
 */
public class TwoStackBeQueen {
    public static void main(String[] args) {

    }
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        //队列是先进先出，栈是先进后出。
        //用两个栈来实现队列，可以先进A，出栈A后进入B，最终B的出栈顺序为出队列的顺序。

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
